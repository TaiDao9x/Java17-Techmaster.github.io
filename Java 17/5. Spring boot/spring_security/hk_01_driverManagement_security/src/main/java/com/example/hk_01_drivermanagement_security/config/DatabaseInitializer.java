package com.example.hk_01_drivermanagement_security.config;

import com.example.hk_01_drivermanagement_security.entity.Driver;
import com.example.hk_01_drivermanagement_security.entity.Role;
import com.example.hk_01_drivermanagement_security.repository.DriverRepository;
import com.example.hk_01_drivermanagement_security.repository.RoleRepository;
import com.example.hk_01_drivermanagement_security.statics.Roles;
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

    DriverRepository userRepository;

    RoleRepository roleRepository;

    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Role userRole = Role.builder().name(Roles.USER.toString()).build();
        Role adminRole = Role.builder().name(Roles.ADMIN.toString()).build();
        roleRepository.save(userRole);
        roleRepository.save(adminRole);

        Driver driver = new Driver();
        driver.setUsername("admin");
        driver.setPassword(passwordEncoder.encode("admin123")); // Encrypt the password
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        driver.setRoles(roles);
        userRepository.save(driver);
    }

}
