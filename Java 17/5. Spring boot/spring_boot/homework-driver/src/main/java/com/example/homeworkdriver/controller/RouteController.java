package com.example.homeworkdriver.controller;

import com.example.homeworkdriver.model.RouteModel;
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
@RequestMapping("/routes")
public class RouteController {
    RouteService routeService;

    @GetMapping
    public String getAllRoute(Model model) {
        List<RouteModel> routeModels = routeService.getAllRoute();

        model.addAttribute("danhSachTuyenXe", routeModels);
        return "Route-list";
    }

    @GetMapping("create-form")
    public String forwardToCreateNewRoute(Model model, RouteModel routeModel) {
        model.addAttribute("tuyenDuongMoi", routeModel);
        return "create-route";
    }

    @PostMapping
    public String createNewRoute(@ModelAttribute("tuyenDuongMoi") @Valid RouteModel routeModel, Errors errors) {
        if (errors != null && errors.getErrorCount() > 0) {
            return "create-route";
        }
        routeService.createNewRoute(routeModel);
        return ("redirect:/routes");
    }

    @GetMapping("update/{id}")
    public String forwardToUpdateRoute(@PathVariable int id, Model model) {
        RouteModel routeModel = routeService.findRouteModelById(id);
        model.addAttribute("routeMuonSua", routeModel);
        return ("update-route");
    }

    @PostMapping("/update")
    public String updateRoute(@ModelAttribute("routeMuonSua") @Valid RouteModel routeModel, Errors errors) {
        if (errors != null && errors.getErrorCount() > 0) {
            return "update-route";
        }
        routeService.updateRoute(routeModel);
        return ("redirect:/routes");
    }

    @GetMapping("/delete/{id}")
    public String deleteRoute(@PathVariable int id) {
        routeService.deleteRoute(id);
        return ("redirect:/routes");
    }

}
