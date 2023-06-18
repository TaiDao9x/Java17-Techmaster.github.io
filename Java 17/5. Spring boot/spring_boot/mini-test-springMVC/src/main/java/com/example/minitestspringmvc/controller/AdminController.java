package com.example.minitestspringmvc.controller;

import com.example.minitestspringmvc.exception.NotFoundException;
import com.example.minitestspringmvc.model.request.AppointmentRequest;
import com.example.minitestspringmvc.model.request.ProductRequest;
import com.example.minitestspringmvc.model.response.AppointmentResponse;
import com.example.minitestspringmvc.model.response.ProductResponse;
import com.example.minitestspringmvc.service.AppointmentService;
import com.example.minitestspringmvc.service.EmailService;
import com.example.minitestspringmvc.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping
public class AdminController {
    ProductService productService;
    AppointmentService appointmentService;
    EmailService emailService;

    // PRODUCT
    // Xem danh sách sản phẩm
    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "adminPage";
    }

    //Tạo SP mới
    @PostMapping("/api/v1/product")
    public ResponseEntity<?> saveProduct(@RequestBody @Valid ProductRequest productRequest) {
        ProductResponse productResponse = productService.saveProduct(productRequest);
        return ResponseEntity.ok(productResponse);
    }

    // Sửa SP
    @PutMapping("/api/v1/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody @Valid ProductRequest productRequest) throws NotFoundException {
        ProductResponse productResponse = productService.updateProduct(id, productRequest);
        return ResponseEntity.ok(productResponse);
    }

    // Lấy ra sản phẩm theo id
    @GetMapping("/api/v1/product/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.ok(productService.findProductById(id));
    }


    // APPOINTMENT
    // Xem danh sách lịch hẹn khám
    @GetMapping("/appointments")
    public String appointmentPage(Model model) {
        model.addAttribute("appointments", productService.getAllAppointment());
        return "appointment-management";
    }

    // confirm lịch khám
    @PutMapping("/api/v1/appointment/{id}")
    public ResponseEntity<?> updateAppointment(@PathVariable Integer id, @RequestBody AppointmentRequest appointmentRequest) throws NotFoundException {
        AppointmentResponse appointmentResponse = appointmentService.updateAppointment(id, appointmentRequest);
        return ResponseEntity.ok(appointmentResponse);
    }
}
