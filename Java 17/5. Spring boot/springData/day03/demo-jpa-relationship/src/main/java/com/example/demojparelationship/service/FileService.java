package com.example.demojparelationship.service;

import com.example.demojparelationship.entity.Image;
import com.example.demojparelationship.repository.FileRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileService {
    FileRepository fileRepository;

    public List<Image> findFileByUserId(Integer userId) {
        return fileRepository.findAllImageByUserId(userId);
    }

    public void deleteFileById(Integer fileId) {
        fileRepository.deleteById(fileId);
    }

}
