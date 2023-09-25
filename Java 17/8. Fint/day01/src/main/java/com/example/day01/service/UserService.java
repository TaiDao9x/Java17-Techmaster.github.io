package com.example.day01.service;

import com.example.day01.entity.Role;
import com.example.day01.entity.User;
import com.example.day01.model.request.CreateUserRequest;
import com.example.day01.model.request.UpdateUserRequest;
import com.example.day01.model.request.UserSearchRequest;
import com.example.day01.model.response.CommonResponse;
import com.example.day01.model.response.UserResponse;
import com.example.day01.repository.RoleRepository;
import com.example.day01.repository.UserRepository;
import com.example.day01.repository.custom.UserCustomRepository;
import com.example.day01.security.JwtUtils;
import com.example.day01.security.SecurityUltils;
import com.example.day01.statics.Roles;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.OpenOption;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserService {
    @Autowired
    final PasswordEncoder passwordEncoder;
    @Autowired
    final UserRepository userRepository;
    @Autowired
    final RoleRepository roleRepository;
    @Autowired
    final JwtUtils jwtUtils;
    @Autowired
    EmailService emailService;
    @Autowired
    UserCustomRepository userCustomRepository;

    public UserResponse getUser(Long userId) {
        User user = findUser(userId);

        return UserResponse.builder()
                .email(user.getEmail())
                .phone(user.getPhone())
                .fullName(user.getFullName())
                .build();
    }

    public void registerUser(CreateUserRequest request) {
        Optional<Role> roleOptional = roleRepository.findByName(Roles.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(roleOptional.get());

        User user = User.builder()
                .email(request.getEmail())
                .fullName(request.getFullName())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .roles(roles)
                .build();

        userRepository.save(user);
        emailService.sendOtp(user.getEmail());
    }

    public UserResponse updateUser(Long userId, UpdateUserRequest request) {
        User user = findUser(userId);
        user.setFullName(request.getFullName().equals("") ? user.getFullName() : request.getFullName());
        user.setPhone(request.getPhone().equals("") ? user.getPhone() : request.getPhone());
        userRepository.save(user);

        return UserResponse.builder()
                .fullName(user.getFullName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }

    public void deleteUser() {
        Long userId = getUerId();
        User user = findUser(userId);
        userRepository.delete(user);
    }

    private User findUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Not found user");
        }
        return userOptional.get();
    }

    private Long getUerId() {
        Optional<Long> userId = SecurityUltils.getCurrentUserLoginId();
        if (userId.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return userId.get();
    }

    public CommonResponse<?> searchUsers(UserSearchRequest request) {
        try {
            List<UserResponse> userResponses = userCustomRepository.searchUser(request);
            Integer totalResult = userResponses.size();

            Integer pageIndex = request.getPageIndex();
            Integer pageSize = request.getPageSize();

            PaginationUtils<UserResponse> paginationUtils = new PaginationUtils<>();
            Integer numberOfPages = paginationUtils.calculateNumberOfPages(userResponses, pageSize);
            userResponses = paginationUtils.searchData(userResponses, pageIndex, pageSize);

            return CommonResponse.builder()
                    .data(userResponses)
                    .totalResult(totalResult)
                    .numberOfPages(numberOfPages)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Page index out of bound");
        }
    }
}
