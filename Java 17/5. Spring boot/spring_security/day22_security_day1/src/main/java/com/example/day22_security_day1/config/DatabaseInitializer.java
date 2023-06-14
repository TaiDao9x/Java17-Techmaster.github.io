package com.example.day22_security_day1.config;

import com.example.day22_security_day1.entity.Role;
import com.example.day22_security_day1.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.day22_security_day1.repository.RoleRepository;
import com.example.day22_security_day1.repository.UserRepository;
import com.example.day22_security_day1.statics.Roles;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DatabaseInitializer implements CommandLineRunner {
    UserRepository userRepository;

    RoleRepository roleRepository;

    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Role userRole = Role.builder().name(Roles.USER.toString()).build();
        Role adminRole = Role.builder().name(Roles.ADMIN.toString()).build();
        roleRepository.save(userRole);
        roleRepository.save(adminRole);

        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin123"));
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        user.setRoles(roles);
        userRepository.save(user);
    }
}
