package com.example.day22_springsecurity_day01.config;

import com.example.day22_springsecurity_day01.entity.Role;
import com.example.day22_springsecurity_day01.entity.User;
import com.example.day22_springsecurity_day01.repository.RoleRepository;
import com.example.day22_springsecurity_day01.repository.UserRepository;
import com.example.day22_springsecurity_day01.statics.Roles;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DatabaseInitializer implements CommandLineRunner {
    UserRepository userRepository;
    RoleRepository roleRepository;
    PasswordEncoder passwordEncode;

    @Override
    public void run(String... args) throws Exception {
        Role userRole = Role.builder().name(Roles.USER.toString()).build();
        Role adminRole = Role.builder().name(Roles.ADMIN.toString()).build();
        roleRepository.save(userRole);
        roleRepository.save(adminRole);

        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncode.encode("admin123"));

        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        user.setRoles(roles);
        userRepository.save(user);

    }
}
