package com.example.demojpa.service;

import com.example.demojpa.entity.Todo;
import com.example.demojpa.repository.TodoRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TodoService {
    TodoRepository todoRepository;

    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void updateTodo(Todo todo) {
    }

    public void deleteTodo(Todo todo) {
    }
}
