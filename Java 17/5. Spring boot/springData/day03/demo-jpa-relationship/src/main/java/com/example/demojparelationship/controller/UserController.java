package com.example.demojparelationship.controller;

import com.example.demojparelationship.entity.Image;
import com.example.demojparelationship.service.FileService;
import com.example.demojparelationship.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@AllArgsConstructor
@RequestMapping
public class UserController {
    private UserService userService;
    private FileService fileService;

    @GetMapping("/")
    public String getUserPage(Model model) {
        model.addAttribute("users", userService.findAllUsers());

        return "index";
    }

    @GetMapping("/users/{userId}/files")
    public String getFilesPage(Model model, @PathVariable Integer userId) {
        model.addAttribute("files", fileService.findFileByUserId(userId));

        return "file";
    }

//    @GetMapping("/api/v1/files/{id}")
//    public ResponseEntity<?> readFile(@PathVariable Integer id) {
//
//    }

    @DeleteMapping("/api/v1/files/{fileId}")
    public ResponseEntity<?> deleteFile(@PathVariable Integer fileId) {
        fileService.deleteFileById(fileId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/api/v1/files/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@RequestPart("file") MultipartFile multipartFile, @PathVariable Integer userId) throws IOException {
        fileService.uploadFile(multipartFile, userId);
        return ResponseEntity.ok(null);
    }
}
