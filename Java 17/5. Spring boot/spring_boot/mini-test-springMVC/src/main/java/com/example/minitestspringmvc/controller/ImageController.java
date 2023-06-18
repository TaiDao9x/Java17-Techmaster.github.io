package com.example.minitestspringmvc.controller;

import com.example.minitestspringmvc.model.response.ImageResponse;
import com.example.minitestspringmvc.service.AppointmentService;
import com.example.minitestspringmvc.service.EmailService;
import com.example.minitestspringmvc.service.OrderService;
import com.example.minitestspringmvc.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@AllArgsConstructor
@RequestMapping
public class ImageController {
    ProductService productService;
    AppointmentService appointmentService;
    OrderService orderService;
    EmailService emailService;

    @PostMapping("/api/v1/image")
    public ResponseEntity<?> saveImage(@RequestParam("image") MultipartFile file) {
        ImageResponse imageResponse = productService.saveImage(file);
        return ResponseEntity.ok(imageResponse);
    }

    //lấy image sản phẩm
    @GetMapping("/api/v1/image/{id}")
    public ResponseEntity<?> getImageByProductId(@PathVariable Integer id) {
        ImageResponse imageResponse = productService.getImageByProductId(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(imageResponse.getType()))
                .body(imageResponse.getData());
    }
}
