package com.example.demojparelationship.service;

import com.example.demojparelationship.entity.Image;
import com.example.demojparelationship.entity.User;
import com.example.demojparelationship.repository.FileRepository;
import com.example.demojparelationship.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FileService {
    FileRepository fileRepository;
    UserRepository userRepository;

    public List<Image> findFileByUserId(Integer userId) {
        return fileRepository.findAllImageByUserId(userId);
    }

    public void deleteFileById(Integer fileId) {
        fileRepository.deleteById(fileId);
    }

    public Image uploadFile(MultipartFile multipartFile, Integer userId) throws IOException {
        User user = userRepository.findById(userId).orElseThrow(() -> {
            throw new RuntimeException("User not found");
        });
        Image image = Image.builder()
                .createdAt(LocalDateTime.now())
                .data(multipartFile.getBytes())
                .type(multipartFile.getContentType())
                .user(user)
                .build();
        fileRepository.save(image);
        return image;
    }

    public Image readFile(Integer id) {
        //        Optional<Image> image = fileRepository.findById(id);
        return fileRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("file not find");
        });
    }
}
