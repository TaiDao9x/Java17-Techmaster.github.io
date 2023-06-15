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

    public void uploadFile(MultipartFile multipartFile, Integer userId) throws IOException {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            Image image = Image.builder()
                    .createdAt(LocalDateTime.now())
                    .data(multipartFile.getBytes())
                    .type(multipartFile.getContentType())
                    .user(user.get())
                    .build();
            fileRepository.save(image);
        }

    }
}
