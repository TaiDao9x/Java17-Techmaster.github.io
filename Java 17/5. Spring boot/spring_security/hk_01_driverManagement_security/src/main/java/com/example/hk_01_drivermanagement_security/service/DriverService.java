package com.example.hk_01_drivermanagement_security.service;

import com.example.hk_01_drivermanagement_security.entity.Driver;
import com.example.hk_01_drivermanagement_security.entity.Role;
import com.example.hk_01_drivermanagement_security.model.request.DriverCreateRequest;
import com.example.hk_01_drivermanagement_security.model.request.DriverUpdateRequest;
import com.example.hk_01_drivermanagement_security.model.respond.DriverResponse;
import com.example.hk_01_drivermanagement_security.repository.DriverRepository;
import com.example.hk_01_drivermanagement_security.repository.RoleRepository;
import com.example.hk_01_drivermanagement_security.statics.Roles;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DriverService {
    PasswordEncoder passwordEncoder;
    DriverRepository driverRepository;
    RoleRepository roleRepository;
    ObjectMapper objectMapper;


    public DriverResponse findDriverById(Integer id) {
        Driver driver = driverRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Driver not found");
        });
        return objectMapper.convertValue(driver, DriverResponse.class);
    }

    public void createNewDriver(DriverCreateRequest driverCreateRequest) {
        Optional<Role> roleOptional = roleRepository.findByName(Roles.USER.name());
        Set<Role> roles = new HashSet<>();
        roles.add(roleOptional.get());

        Driver newDriver = objectMapper.convertValue(driverCreateRequest, Driver.class);
        newDriver.setRoles(roles);
        newDriver.setPassword(passwordEncoder.encode(driverCreateRequest.getPassword()));
        driverRepository.save(newDriver);
    }

    public void updateDriver(int id, DriverUpdateRequest driverUpdateRequest) {
        Driver driver = driverRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Driver not found");
        });
        driver.setName(driverUpdateRequest.getName());
        driver.setUsername(driverUpdateRequest.getUsername());
        driver.setPassword(driverUpdateRequest.getPassword());
        driver.setAddress(driverUpdateRequest.getAddress());
        driver.setPhone(driverUpdateRequest.getPhone());
        driver.setLevel(driverUpdateRequest.getLevel());
        driverRepository.save(driver);
    }

    public void deleteDriver(int id) {
        driverRepository.deleteById(id);
    }
}
