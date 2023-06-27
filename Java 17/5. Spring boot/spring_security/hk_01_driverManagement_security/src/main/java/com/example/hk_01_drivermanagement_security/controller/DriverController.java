package com.example.hk_01_drivermanagement_security.controller;

import com.example.hk_01_drivermanagement_security.model.request.DriverCreateRequest;
import com.example.hk_01_drivermanagement_security.model.request.DriverUpdateRequest;
import com.example.hk_01_drivermanagement_security.service.DriverService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/drivers")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class DriverController {
    DriverService driverService;

    @PostMapping
    public ResponseEntity<?> createNewDriver(@RequestBody @Valid DriverCreateRequest driverCreateRequest) {
        driverService.createNewDriver(driverCreateRequest);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDriver(@PathVariable int id, @RequestBody @Valid DriverUpdateRequest driverUpdateRequest) {
        driverService.updateDriver(id, driverUpdateRequest);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable int id) {
        driverService.deleteDriver(id);
        return ResponseEntity.ok(null);
    }

}
