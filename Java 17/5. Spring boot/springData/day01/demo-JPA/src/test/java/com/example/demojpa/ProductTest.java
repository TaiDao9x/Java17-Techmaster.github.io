package com.example.demojpa;

import com.example.demojpa.entity.Product;
import com.example.demojpa.repository.ProductRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@SpringBootTest
public class ProductTest {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Faker faker;

    @Test
    void saveProduct() {
        Random rd = new Random();
        for (int i = 0; i < 5; i++) {
            Product product = new Product(null, faker.name().fullName(), String.valueOf(rd.nextInt(100)), faker.name().lastName(), LocalDateTime.now(), i);
            productRepository.save(product);
        }
    }

    @Test
    void findByNameAndOrderByName() {
        Optional<List<Product>> rs = productRepository.findByNameOrderByNameDesc("Leisha Nicolas");
        if (rs.isEmpty()) {
            System.out.println("trống");
            return;
        }
        rs.get().forEach(System.out::println);
    }

    @Test
    void findByname() {
        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<Product> rs = productRepository.findAllByNameContainingIgnoreCase("e", pageRequest);
        rs.getContent().forEach(System.out::println);
    }

}
