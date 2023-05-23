package com.example.homeworkdriver.service;


import com.example.homeworkdriver.entity.Route;
import com.example.homeworkdriver.model.RouteModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RouteService {
    ObjectMapper objectMapper;
    private static final List<Route> routeList = new ArrayList<>();
    private static int AUTO_ID = 101;

    static {
        Route route = new Route(100, "My Dinh - Time city", 10.3, 10);
        routeList.add(route);
    }


    public List<RouteModel> getAllRoute() {
        List<RouteModel> routeModels = new ArrayList<>();
        routeList.forEach(route -> {
            RouteModel RouteModel = objectMapper.convertValue(route, RouteModel.class);
            routeModels.add(RouteModel);
        });
        return routeModels;
    }

    public Route findRouteById(int id) {
        for (Route route : routeList) {
            if (route.getId() == id) return route;
        }
        return null;
    }

    public RouteModel findRouteModelById(int id) {
        for (Route route : routeList) {
            if (route.getId() == id) return objectMapper.convertValue(route, RouteModel.class);
        }
        return null;
    }

    public void createNewRoute(RouteModel routeModel) {
        Route route = objectMapper.convertValue(routeModel, Route.class);
        route.setId(AUTO_ID);
        AUTO_ID++;
        routeList.add(route);
    }

    public void updateRoute(RouteModel routeModel) {
        Route route = findRouteById(routeModel.getId());
        if (route == null) return;

        route.setDistance(routeModel.getDistance());
        route.setName(routeModel.getName());
        route.setNumberOfStop(routeModel.getNumberOfStop());
    }

    public void deleteRoute(int id) {
        routeList.removeIf(route -> route.getId() == id);
    }

}
