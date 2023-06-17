package com.example.lab1;

import com.example.lab1.entity.Supporter;
import com.example.lab1.repository.SupporterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lab1ApplicationTests {
    @Autowired
    SupporterRepository supporterRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void saveSupporter() {
        Supporter supporter = Supporter.builder()

                .build();
    }
}
