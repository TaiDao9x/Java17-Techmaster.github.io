package com.example.hk_01_drivermanagement_security.service;

import com.example.hk_01_drivermanagement_security.entity.Route;
import com.example.hk_01_drivermanagement_security.model.request.RouteRequest;
import com.example.hk_01_drivermanagement_security.model.respond.RouteResponse;
import com.example.hk_01_drivermanagement_security.repository.RouteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class RouteService {
    RouteRepository routeRepository;
    ObjectMapper objectMapper;

    public RouteResponse findRouteById(int id) {
        Route route = routeRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Route not found");
        });
        return objectMapper.convertValue(route, RouteResponse.class);
    }

    public void createNewRoute(RouteRequest routeRequest) {
        Route newRoute = objectMapper.convertValue(routeRequest, Route.class);
        routeRepository.save(newRoute);
    }

    public void updateRoute(int id, RouteRequest routeRequest) {
        Route route = routeRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Route not found");
        });
        route.setName(routeRequest.getName());
        route.setDistance(routeRequest.getDistance());
        route.setNumberOfStop(routeRequest.getNumberOfStop());
        routeRepository.save(route);
    }

    public void deleteRoute(int id) {
        routeRepository.deleteById(id);
    }
}
