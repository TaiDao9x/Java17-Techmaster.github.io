package com.example.lab1;

import com.example.lab1.entity.Course;
import com.example.lab1.entity.Supporter;
import com.example.lab1.entity.Topic;
import com.example.lab1.repository.CourseRepository;
import com.example.lab1.repository.SupporterRepository;
import com.example.lab1.repository.TopicRepository;
import com.example.lab1.statics.TypeStudy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Lab1ApplicationTests {
    @Autowired
    SupporterRepository supporterRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    CourseRepository courseRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void saveSupporter() {
        Supporter supporter = Supporter.builder()
                .name("Phạm Thị Mẫn")
                .email("man@gmail.com")
                .phone("0987654321")
                .build();
        supporterRepository.save(supporter);
        Supporter supporter1 = Supporter.builder()
                .name("Phạm Thanh Hương")
                .email("huong@gmail.com")
                .phone("0987604321")
                .build();
        supporterRepository.save(supporter1);
    }

    @Test
    void topic() {
        Topic topic = Topic.builder()
                .name("FrontEnd")
                .build();
        Topic topic1 = Topic.builder()
                .name("Backend")
                .build();
        Topic topic2 = Topic.builder()
                .name("Devops")
                .build();
        Topic topic3 = Topic.builder()
                .name("Database")
                .build();
        topicRepository.save(topic);
        topicRepository.save(topic1);
        topicRepository.save(topic2);
        topicRepository.save(topic3);
    }

    @Test
    void course() {
        Supporter supporter = Supporter.builder()
                .name("Phạm Thanh Hương")
                .email("huong@gmail.com")
                .phone("0987604321")
                .build();
        supporterRepository.save(supporter);

        Topic topic1 = Topic.builder()
                .name("Backend")
                .build();
        Topic topic3 = Topic.builder()
                .name("Database")
                .build();
        topicRepository.save(topic1);
        topicRepository.save(topic3);
        List<Topic> topics = new ArrayList<>();
        topics.add(topic1);
        topics.add(topic3);

        Course course = Course.builder()
                .name("Java")
                .description("")
                .typeStudy(TypeStudy.ONLINE)
                .supporter(supporter)
                .topics(topics)
                .thumbnail("")
                .build();
        courseRepository.save(course);
    }
}
