package com.example.courseadmin.service;

import com.example.courseadmin.entity.Topic;
import com.example.courseadmin.model.request.TopicRequest;
import com.example.courseadmin.repository.TopicRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {
    TopicRepository topicRepository;
    ObjectMapper objectMapper;

    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    public Topic createTopic(TopicRequest topicRequest) {
        Topic topic = Topic.builder().name(topicRequest.getName()).build();
        topicRepository.save(topic);
        return topic;
    }

    public Topic updateTopic(Integer id, TopicRequest topicRequest) {
        Topic topic = topicRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found topic");
        });
        topic.setName(topicRequest.getName());
        topicRepository.save(topic);
        return topic;
    }

    public void deleteTopic(Integer id) {
        topicRepository.deleteById(id);
    }

}
