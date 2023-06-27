package com.example.hk_01_drivermanagement_security.service;

import com.example.hk_01_drivermanagement_security.entity.Assignement;
import com.example.hk_01_drivermanagement_security.model.request.AssignementRequest;
import com.example.hk_01_drivermanagement_security.repository.AssignmentRepository;
import com.example.hk_01_drivermanagement_security.repository.DriverRepository;
import com.example.hk_01_drivermanagement_security.repository.RouteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AssignmentService {
    AssignmentRepository assignmentRepository;
    DriverRepository driverRepository;
    RouteRepository routeRepository;
    ObjectMapper objectMapper;

    public void createNewAssignment(AssignementRequest taoPhanCongMoi) {
        Assignement assignement = objectMapper.convertValue(taoPhanCongMoi, Assignement.class);
        assignmentRepository.save(assignement);
    }

    public void updateAssignment(int id, AssignementRequest assignementRequest) {
        Assignement assignement = assignmentRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Assignment not found!");
        });
        assignement.setDriver(driverRepository.findById(id).orElseThrow(() -> {
                    throw new RuntimeException("Driver not found!");
                })
        );
        assignement.setRoute(routeRepository.findById(id).orElseThrow(() -> {
                    throw new RuntimeException("Route not found");
                })
        );
        assignement.setDateOfAssignment(assignementRequest.getDateOfAssignment());
        assignement.setNumberOfTurn(assignementRequest.getNumberOfTurn());
        assignmentRepository.save(assignement);
    }
}
