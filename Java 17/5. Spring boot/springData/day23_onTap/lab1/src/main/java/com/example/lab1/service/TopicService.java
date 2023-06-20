package com.example.lab1.service;

import com.example.lab1.entity.Topic;
import com.example.lab1.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {
    TopicRepository topicRepository;

    public List<Topic> findAllTopic() {
        return topicRepository.findAll();
    }
}
