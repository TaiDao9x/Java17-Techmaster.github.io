package com.example.day26_jwt_refreshtoken.service;

import com.example.day26_jwt_refreshtoken.entity.Role;
import com.example.day26_jwt_refreshtoken.entity.User;
import com.example.day26_jwt_refreshtoken.exception.ExistedUserException;
import com.example.day26_jwt_refreshtoken.exception.RefreshTokenNotFoundException;
import com.example.day26_jwt_refreshtoken.model.request.CreateUserRequest;
import com.example.day26_jwt_refreshtoken.model.request.RefreshTokenRequest;
import com.example.day26_jwt_refreshtoken.model.request.RegistrationRequest;
import com.example.day26_jwt_refreshtoken.model.response.JwtResponse;
import com.example.day26_jwt_refreshtoken.model.response.UserResponse;
import com.example.day26_jwt_refreshtoken.repository.RefreshTokenRepository;
import com.example.day26_jwt_refreshtoken.repository.RoleRepository;
import com.example.day26_jwt_refreshtoken.repository.UserRepository;
import com.example.day26_jwt_refreshtoken.security.CustomUserDetails;
import com.example.day26_jwt_refreshtoken.security.JwtUtils;
import com.example.day26_jwt_refreshtoken.security.SecurityUtils;
import com.example.day26_jwt_refreshtoken.statics.Roles;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserService {
    PasswordEncoder passwordEncoder;

    UserRepository userRepository;

    RoleRepository roleRepository;

    ObjectMapper objectMapper;

    RefreshTokenRepository refreshTokenRepository;

    @Value("${application.security.refreshToken.tokenValidityMilliseconds}")
    long refreshTokenValidityMilliseconds;

    JwtUtils jwtUtils;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository, ObjectMapper objectMapper, RefreshTokenRepository refreshTokenRepository, JwtUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.objectMapper = objectMapper;
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtUtils = jwtUtils;
    }

    public void registerUser(@Valid RegistrationRequest request) {
        Optional<Role> role = roleRepository.findByName(Roles.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(role.get());

        User user = User.builder()
                .username(request.getUsername())
                .roles(roles)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
    }

    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        if (!CollectionUtils.isEmpty(users)) {
            return users.stream()
                    .map(user -> objectMapper.convertValue(user, UserResponse.class))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public UserResponse getDetail(Long id) throws ClassNotFoundException {
        return userRepository.findById(id)
                .map(user -> objectMapper.convertValue(user, UserResponse.class))
                .orElseThrow(ClassNotFoundException::new);
    }

    @Transactional
    public void logout() {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();
        if (userIdOptional.isEmpty()) {
            throw new UsernameNotFoundException("User is not exist");
        }
        refreshTokenRepository.logout(userIdOptional.get());
        SecurityContextHolder.clearContext();
    }

    public JwtResponse refreshToken(RefreshTokenRequest request) throws RefreshTokenNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String newToken = userRepository.findById(userDetails.getId())
                .flatMap(user -> refreshTokenRepository.findByUserAndRefreshTokenAndInvalidated(user, request.getRefreshToken(), false)
                        .map(refreshToken -> {
                            LocalDateTime createdDateTime = refreshToken.getCreatedDateTime();
                            LocalDateTime expiryTime = createdDateTime.plusSeconds(refreshTokenValidityMilliseconds / 1000);
                            if (expiryTime.isBefore(LocalDateTime.now())) {
                                refreshToken.setInvalidated(true);
                                refreshTokenRepository.save(refreshToken);
                                return null;
                            }
                            return jwtUtils.generateJwtToken(authentication);
                        }))
                .orElseThrow(() -> new UsernameNotFoundException("Tài khoản không tồn tại"));
        if (newToken == null) {
            throw new RefreshTokenNotFoundException();
        }
        return JwtResponse.builder()
                .jwt(newToken)
                .build();
    }

    public void createUser(CreateUserRequest request) throws ExistedUserException {
        Optional<User> userOptional = userRepository.findByUsername(request.getUsername());
        if (!userOptional.isEmpty()) {
            throw new ExistedUserException();
        }

        Set<Role> roles = roleRepository.findByName(Roles.USER).stream().collect(Collectors.toSet());

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode("123"))
                .roles(roles)
                .build();
        userRepository.save(user);
    }
}
