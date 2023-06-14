package com.example.day20fileuploading.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class UserService {
    private static final String LOCAL_FOLDER = "/Users/WIN 10/Desktop";

    public String uploadLocalFile(MultipartFile avatarImage) throws IOException {
        if (ObjectUtils.isEmpty(avatarImage) || avatarImage.isEmpty()) {
            return null;
        }
        String filePath = LOCAL_FOLDER + File.separator + avatarImage.getOriginalFilename();
        Files.copy(avatarImage.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
        return filePath;
    }
}
