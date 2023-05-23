package com.example.homeworkdriver.controller;

import com.example.homeworkdriver.model.AssignmentRouteModel;
import com.example.homeworkdriver.service.AssignmentRouteService;
import com.example.homeworkdriver.service.DriverService;
import com.example.homeworkdriver.service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/assignments")
public class AssignmentRouteController {
    AssignmentRouteService assignmentRouteService;
    DriverService driverService;
    RouteService routeService;

    @GetMapping
    public String getAllRoute(Model model) {
        List<AssignmentRouteModel> assignmentRouteModels = assignmentRouteService.getAllRoute();

        model.addAttribute("bangPhanCong", assignmentRouteModels);
        return "Assignment-route";
    }

    @GetMapping("create-form")
    public String forwardToCreateNewAssignment(Model model, AssignmentRouteModel assignmentRouteModel) {
        getDriverAndRoute(model);

        model.addAttribute("taoPhanCongMoi", assignmentRouteModel);
        return "create-assignment";
    }

    @PostMapping
    public String createNewAssignment(@ModelAttribute("taoPhanCongMoi") @Valid AssignmentRouteModel assignmentRouteModel, Model model, Errors errors) {
        if (errors != null && errors.getErrorCount() > 0) {
            getDriverAndRoute(model);
            return "create-assignment";
        }
        assignmentRouteService.createNewAssignment(assignmentRouteModel);
        return ("redirect:/assignments");
    }

    @GetMapping("/update/{id}")
    public String forwardToUpdateAssignment(@PathVariable int id, Model model) {
        AssignmentRouteModel assignmentRouteModel = assignmentRouteService.findAssignmentRouteModelbyId(id);
        getDriverAndRoute(model);
        model.addAttribute("assignmentMuonSua", assignmentRouteModel);
        return "update-assignment";
    }

    @PostMapping("/update")
    public String updateAssignment(@ModelAttribute("assignmentMuonSua") @Valid AssignmentRouteModel assignmentRouteModel, Model model, Errors errors) {
        if (errors != null && errors.getErrorCount() > 0) {
            getDriverAndRoute(model);
            return "update-assignment";
        }
        assignmentRouteService.updateAssignment(assignmentRouteModel);
        return ("redirect:/assignments");
    }

    private void getDriverAndRoute(Model model) {
        model.addAttribute("danhSachDriver", driverService.getAllDriver());
        model.addAttribute("danhSachRoute", routeService.getAllRoute());
    }

}
