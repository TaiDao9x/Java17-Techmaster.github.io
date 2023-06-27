package com.example.hk_01_drivermanagement_security.controller;

import com.example.hk_01_drivermanagement_security.model.request.RouteRequest;
import com.example.hk_01_drivermanagement_security.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/routes")

public class RouteController {
    RouteService routeService;

    @PostMapping
    public ResponseEntity<?> createNewRoute(@RequestBody @Valid RouteRequest routeRequest) {
        routeService.createNewRoute(routeRequest);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRoute(@PathVariable int id, @RequestBody @Valid RouteRequest routeRequest) {
        routeService.updateRoute(id, routeRequest);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoute(@PathVariable int id) {
        routeService.deleteRoute(id);
        return ResponseEntity.ok(null);
    }
}
