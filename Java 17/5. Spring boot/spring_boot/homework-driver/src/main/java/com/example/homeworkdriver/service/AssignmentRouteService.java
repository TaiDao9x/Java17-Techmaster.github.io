package com.example.homeworkdriver.service;

import com.example.homeworkdriver.entity.AssignmentRoute;
import com.example.homeworkdriver.entity.Driver;
import com.example.homeworkdriver.entity.Route;
import com.example.homeworkdriver.model.AssignmentRouteModel;
import com.example.homeworkdriver.statics.Level;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AssignmentRouteService {
    ObjectMapper objectMapper;
    DriverService driverService;
    RouteService routeService;

    private static List<AssignmentRoute> assignmentRouteList = new ArrayList<>();
    private static int AUTO_ID = 2;

    static {
        Driver driver = new Driver(1, "abc", "HN", "0987654321", Level.B);
        Route route = new Route(1, "Ho Tay-Linh Dam", 20.0, 15);

        AssignmentRoute assignmentRoute = new AssignmentRoute(1, driver, route, 5, LocalDate.now());
        assignmentRouteList.add(assignmentRoute);
    }

    public List<AssignmentRouteModel> getAllRoute() {
        List<AssignmentRouteModel> assignmentRouteModels = new ArrayList<>();
        assignmentRouteList.forEach(assignmentRoute -> {
            AssignmentRouteModel assignmentRouteModel = AssignmentRouteModel.builder()
                    .id(assignmentRoute.getId())
                    .driverId(assignmentRoute.getDriver().getId())
                    .driverName(assignmentRoute.getDriver().getName())
                    .routeId(assignmentRoute.getRoute().getId())
                    .routeName(assignmentRoute.getRoute().getName())
                    .numberOfTurn(assignmentRoute.getNumberOfTurn())
                    .build();
            assignmentRouteModels.add(assignmentRouteModel);
        });
        return assignmentRouteModels;
    }

    public void createNewAssignment(AssignmentRouteModel assignmentRouteModel) {

        Driver driver = driverService.findDriverById(assignmentRouteModel.getDriverId());
        Route route = routeService.findRouteById(assignmentRouteModel.getRouteId());

        AssignmentRoute assignmentRoute = new AssignmentRoute(AUTO_ID, driver, route, assignmentRouteModel.getNumberOfTurn(), assignmentRouteModel.getDateOfAssignment());
        AUTO_ID++;
        assignmentRouteList.add(assignmentRoute);
    }

    public AssignmentRouteModel findAssignmentRouteModelbyId(int id) {

        for (AssignmentRoute assignment : assignmentRouteList) {
            if (assignment.getId() == id) {
                return AssignmentRouteModel.builder()
                        .id(assignment.getId())
                        .driverId(assignment.getDriver().getId())
                        .driverName(assignment.getDriver().getName())
                        .routeId(assignment.getRoute().getId())
                        .routeName(assignment.getRoute().getName())
                        .numberOfTurn(assignment.getNumberOfTurn())
                        .dateOfAssignment(assignment.getDateOfAssignment())
                        .build();
            }
        }
        return null;
    }

    public void updateAssignment(AssignmentRouteModel assignmentRouteModel) {
        assignmentRouteList.forEach(assignmentRoute -> {
            if (assignmentRoute.getId() == assignmentRouteModel.getId()) {
                assignmentRoute.setDriver(driverService.findDriverById(assignmentRouteModel.getDriverId()));
                assignmentRoute.setRoute(routeService.findRouteById(assignmentRouteModel.getRouteId()));
                assignmentRoute.setNumberOfTurn(assignmentRouteModel.getNumberOfTurn());
                assignmentRoute.setDateOfAssignment(assignmentRouteModel.getDateOfAssignment());
            }
        });
    }
}