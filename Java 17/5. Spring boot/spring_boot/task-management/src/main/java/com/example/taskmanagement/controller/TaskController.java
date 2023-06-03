package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.request.TaskRequest;
import com.example.taskmanagement.model.response.TaskResponse;
import com.example.taskmanagement.service.TaskService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class TaskController {

    TaskService taskService;

    @GetMapping("/")
    public String getAllTask(Model model) {
        List<TaskResponse> taskResponses = taskService.getAll();
        model.addAttribute("tasks", taskResponses);

        return "index";
    }

    /*
     * API
     */

    @PostMapping("/api/v1/tasks")
    public ResponseEntity<?> createTask(@RequestBody @Valid TaskRequest taskRequest) {
        taskService.saveTask(taskRequest);

        return new ResponseEntity<>(taskRequest, HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/tasks/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Integer id, @RequestBody @Valid TaskRequest taskRequest) {
        taskRequest.setId(id);
        taskService.saveTask(taskRequest);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/api/v1/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Integer id) {


        return ResponseEntity.ok(null);
    }

    @GetMapping("/api/v1/tasks/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.findTaskDetailById(id));
    }

    @GetMapping("/api/v1/tasks/status")
    public ResponseEntity<?> getTaskStatus() {
        return ResponseEntity.ok(taskService.getTaskStatus());
    }
}
