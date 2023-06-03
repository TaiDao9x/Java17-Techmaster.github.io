package com.example.taskmanagement.repository;

import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.model.request.TaskRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class TaskRepository {

    private List<Task> tasks = new ArrayList<>();

    private static int AUTO_ID = 1;

    public List<Task> getAllTask() {
        return tasks;
    }

    public void addTask(Task newTask) {
        newTask.setId(AUTO_ID);
        AUTO_ID++;
        tasks.add(newTask);
    }

    public Task findTaskByid(Integer id) {
        for (Task task : tasks) {
            if (task.getId() == id) return task;
        }
        return null;
    }

    public void updateTask(Task taskRequest) {
        Task task = findTaskByid(taskRequest.getId());

        task.setName(taskRequest.getName());
        task.setExpectedEndTime(taskRequest.getExpectedEndTime());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(taskRequest.getStatus());
//        BeanUtils.copyProperties(task, t);
    }

    public boolean checkTaskExit(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) return true;
        }
        return false;
    }

    public void deleteTask(Integer id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}
