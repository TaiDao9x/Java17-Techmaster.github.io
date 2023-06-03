package com.example.taskmanagement.service;

import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.model.request.TaskRequest;
import com.example.taskmanagement.model.response.TaskDetailResponse;
import com.example.taskmanagement.model.response.TaskResponse;
import com.example.taskmanagement.model.response.TaskStatusResponse;
import com.example.taskmanagement.repository.TaskRepository;
import com.example.taskmanagement.statics.TaskStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class TaskService {
    ObjectMapper objectMapper;
    TaskRepository taskRepository;


    public List<TaskResponse> getAll() {
//        List<TaskResponse> result = new ArrayList<>();

        List<TaskStatus> taskStatuses = Arrays.asList(TaskStatus.values());
        List<TaskDetailResponse> taskDetailResponses = taskRepository.getAllTask()
                .stream()
                .map(task -> objectMapper.convertValue(task, TaskDetailResponse.class))
                .collect(Collectors.toList());

//        taskStatuses.forEach(taskStatus -> {
//            List<TaskDetailResponse> list = new ArrayList<>();
//            taskDetailResponses.forEach(task -> {
//                if (task.getStatus().equals(taskStatus)) {
//                    list.add(task);
//                }
//            });
//            result.add(new TaskResponse(taskStatus, list));
//        });
//
//        return result;

        return taskStatuses.stream()
                .map(taskStatus -> {
                    List<TaskDetailResponse> list = taskDetailResponses
                            .stream()
                            .filter(task -> task.getStatus().equals(taskStatus)).collect(Collectors.toList());
                    return new TaskResponse(taskStatus, list);
                }).collect(Collectors.toList());
    }

    public List<TaskStatusResponse> getTaskStatus() {
        List<TaskStatus> taskStatuses = Arrays.asList(TaskStatus.values());
        List<TaskStatusResponse> taskStatusResponses = new ArrayList<>();
        taskStatuses.forEach(taskStatus -> {
            TaskStatusResponse taskStatusResponse = new TaskStatusResponse(taskStatus.code, taskStatus.name);
            taskStatusResponses.add(taskStatusResponse);
        });

        return taskStatusResponses;
    }

    public void saveTask(TaskRequest taskRequest) {
        Task newTask = objectMapper.convertValue(taskRequest, Task.class);

        if (taskRepository.checkTaskExit(taskRequest.getId())) {
            taskRepository.updateTask(newTask);
            return;
        }

        newTask.setCreatedDateTime(LocalDateTime.now());
        newTask.setOverdue(newTask.getExpectedEndTime().isBefore(LocalDateTime.now()));
        taskRepository.addTask(newTask);
    }

    public Object findTaskDetailById(Integer id) {
        Task task = taskRepository.findTaskByid(id);
        return objectMapper.convertValue(task, TaskDetailResponse.class);
    }

}
