package com.example.minitestspringmvc.controller;

import com.example.minitestspringmvc.exception.NotFoundException;
import com.example.minitestspringmvc.model.request.AppointmentRequest;
import com.example.minitestspringmvc.model.request.OrderRequest;
import com.example.minitestspringmvc.model.response.AppointmentResponse;
import com.example.minitestspringmvc.service.AppointmentService;
import com.example.minitestspringmvc.service.EmailService;
import com.example.minitestspringmvc.service.OrderService;
import com.example.minitestspringmvc.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping
public class UserController {

    ProductService productService;
    AppointmentService appointmentService;
    OrderService orderService;
    EmailService emailService;

    @GetMapping("/index")
    public String homePage(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "index";
    }

    @RequestMapping("/about")
    public String aboutPage(Model model) {
        return "about";
    }

    @RequestMapping("/contact")
    public String contactPage(Model model) {
        return "contact";
    }

    // Tạo appointment
    @PostMapping("/api/v1/appointment")
    public ResponseEntity<?> createAppointment(@RequestBody @Valid AppointmentRequest appointmentRequest) {
        AppointmentResponse appointmentResponse = appointmentService.createAppointment(appointmentRequest);
        return new ResponseEntity<>(appointmentResponse, HttpStatus.CREATED);
    }

    // Tạo order
    @PostMapping("/api/v1/order/{productId}")
    public ResponseEntity<?> createOrder(@PathVariable Integer productId, @RequestBody @Valid OrderRequest orderRequest) throws NotFoundException {
        orderService.createOrder(productId, orderRequest);
        emailService.sendEmailOrder(productId, orderRequest);
        return ResponseEntity.ok(null);
    }

}
