package com.example.courseadmin;

import com.example.courseadmin.entity.Course;
import com.example.courseadmin.entity.Supporter;
import com.example.courseadmin.entity.Topic;
import com.example.courseadmin.repository.CourseRepository;
import com.example.courseadmin.repository.SupporterRepository;
import com.example.courseadmin.repository.TopicRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@SpringBootTest
class CourseAdminApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    SupporterRepository supporterRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    CourseRepository courseRepository;

    Faker faker = new Faker();

    @Test
    void save_suporter() {
        List<Supporter> supporters = List.of(
                new Supporter(null, "Nguyễn Đức Thịnh", "thinh@gmail.com", "099999999", faker.company().logo()),
                new Supporter(null, "Nguyễn Thanh Hương", "huong@gmail.com", "088888888", faker.company().logo()),
                new Supporter(null, "Phạm Thị Mẫn", "man@gmail.com", "077777777", faker.company().logo())
        );
        supporterRepository.saveAll(supporters);
    }

    @Test
    void save_topic() {
        List<Topic> topics = List.of(
                new Topic(null, "backend"),
                new Topic(null, "frontend"),
                new Topic(null, "devops"),
                new Topic(null, "mobile"),
                new Topic(null, "database")
        );
        topicRepository.saveAll(topics);
    }

    @Test
    void save_course() {
        Random random = new Random();

        List<Supporter> supporters = supporterRepository.findAll();
        List<Topic> topics = topicRepository.findAll();

        for (int i = 0; i < 20; i++) {
            Supporter randSp = supporters.get(random.nextInt(supporters.size()));
            Set<Topic> randTopics = new LinkedHashSet<>();
            for (int j = 0; j < 3; j++) {
                Topic randTopic = topics.get(random.nextInt(topics.size()));
                randTopics.add(randTopic);
            }

            Course course = Course.builder()
                    .name(faker.book().title())
                    .description(faker.lorem().sentence(20))
                    .typeStudy(random.nextInt(2) == 0 ? "Online" : "Onlab")
                    .thumbnail(faker.company().logo())
                    .supporter(randSp)
                    .topics(randTopics)
                    .build();
            courseRepository.save(course);
        }

    }

}
