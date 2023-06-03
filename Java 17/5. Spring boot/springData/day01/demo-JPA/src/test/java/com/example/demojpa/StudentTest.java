package com.example.demojpa;

import com.example.demojpa.entity.Student;
import com.example.demojpa.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
public class StudentTest {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Faker faker;

    @Test
    void save_user() {
        for (int i = 0; i < 20; i++) {
            Student student = new Student(
                    null,
                    faker.name().fullName(),
                    faker.internet().emailAddress()
            );
            studentRepository.save(student);
        }
    }

    @Test
    void findAll_Pageable() {
        PageRequest pageRequest = PageRequest.of(2, 5);
        Page<Student> page = studentRepository.findAll(pageRequest);
        page.getContent().forEach(System.out::println);

        System.out.println();
        PageRequest pageRequest1 = PageRequest.of(2, 5);
        Page<Student> page1 = studentRepository.getAllStudent(pageRequest1);
        page1.getContent().forEach(System.out::println);
    }

    @Test
    void findAllByname_Pageable() {
        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<Student> page = studentRepository.findByNameContainingUsingNq("d", pageRequest);
        page.getContent().forEach(System.out::println);

        System.out.println();
        PageRequest pageRequest1 = PageRequest.of(0, 5);
        Page<Student> page1 = studentRepository.findByNameContainingIgnoreCase("D", pageRequest1);
        page1.getContent().forEach(System.out::println);

    }

}
