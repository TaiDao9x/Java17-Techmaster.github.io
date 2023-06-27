package com.example.courseadmin.service;

import com.example.courseadmin.entity.Supporter;
import com.example.courseadmin.model.request.CreateSupporterRequest;
import com.example.courseadmin.model.request.UpdateSupporterRequest;
import com.example.courseadmin.repository.SupporterRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupporterService {
    SupporterRepository supporterRepository;
    ObjectMapper objectMapper;

    public List<Supporter> getAllSupporter() {
        return supporterRepository.findAll();
    }

    public Supporter saveSupporter(CreateSupporterRequest newSupporter) {
        Supporter supporter = Supporter.builder()
                .name(newSupporter.getName())
                .email(newSupporter.getEmail())
                .phone(newSupporter.getPhone())
                .build();
        supporterRepository.save(supporter);
        return supporter;
    }

    public Supporter updateSupporter(Integer id, UpdateSupporterRequest supporterRequest) {

        Supporter supporter = supporterRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("not found supporter");
        });
        supporter.setName(supporterRequest.getName());
        supporter.setPhone(supporterRequest.getPhone());
        supporter.setAvatar(supporterRequest.getAvatar());
        supporterRepository.save(supporter);
        return supporter;
    }

    public void deleteSupporter(Integer id) {
        supporterRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("not found supporter");
        });
        supporterRepository.deleteById(id);
    }
}
