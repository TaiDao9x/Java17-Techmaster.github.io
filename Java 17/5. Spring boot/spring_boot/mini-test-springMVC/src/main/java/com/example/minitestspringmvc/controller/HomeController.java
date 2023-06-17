package com.example.minitestspringmvc.controller;

import com.example.minitestspringmvc.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping
public class HomeController {
    ProductService productService;

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/api/v1/product")
    public ResponseEntity<?> getAllProduct() {
        return ResponseEntity.ok(productService.getAllProduct());
    }
}
