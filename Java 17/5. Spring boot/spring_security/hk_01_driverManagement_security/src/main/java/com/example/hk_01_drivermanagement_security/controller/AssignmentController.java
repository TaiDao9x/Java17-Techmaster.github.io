package com.example.hk_01_drivermanagement_security.controller;

import com.example.hk_01_drivermanagement_security.model.request.AssignementRequest;
import com.example.hk_01_drivermanagement_security.service.AssignmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/assignments")
public class AssignmentController {
    AssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<?> createNewAssignment(@RequestBody @Valid AssignementRequest taoPhanCongMoi) {
        assignmentService.createNewAssignment(taoPhanCongMoi);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAssignment(@PathVariable int id, @RequestBody @Valid AssignementRequest assignementRequest) {
        assignmentService.updateAssignment(id, assignementRequest);
        return ResponseEntity.ok(null);
    }

}
