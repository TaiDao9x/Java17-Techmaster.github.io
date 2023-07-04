package com.example.day25_jwt_authentication.service;

import com.example.day25_jwt_authentication.entity.Role;
import com.example.day25_jwt_authentication.entity.User;
import com.example.day25_jwt_authentication.model.request.RegistrationRequest;
import com.example.day25_jwt_authentication.model.response.UserResponse;
import com.example.day25_jwt_authentication.repository.RoleRepository;
import com.example.day25_jwt_authentication.repository.UserRepository;
import com.example.day25_jwt_authentication.statics.Roles;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    PasswordEncoder passwordEncoder;

    UserRepository userRepository;

    RoleRepository roleRepository;

    ObjectMapper objectMapper;

    public void registerUser(RegistrationRequest request) {
        Role role = roleRepository.findByName(Roles.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(role);

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
}
