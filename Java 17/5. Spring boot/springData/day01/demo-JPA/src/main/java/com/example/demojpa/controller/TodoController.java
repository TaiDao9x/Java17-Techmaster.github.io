package com.example.demojpa.controller;

import com.example.demojpa.entity.Todo;
import com.example.demojpa.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping
public class TodoController {
    //    private TodoService todoService;
    private TodoRepository todoRepository;

    @GetMapping("")
    public String getIndex(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        return "index";
    }

    @PostMapping("/api/v1/todos")
    public ResponseEntity<?> createNewTodo(@RequestBody Todo todo) {
        Todo newTodo = new Todo(null, todo.getTitle(), false);
        todoRepository.save(newTodo);
        return new ResponseEntity<>(newTodo, HttpStatus.CREATED);//201
    }

    @PutMapping("/api/v1/todos/{id}")
    public ResponseEntity<?> updateNewTodo(@PathVariable Integer id, @RequestBody Todo todo) {
        //kiem tra id
        Todo todo1 = todoRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("not found");
                });

        // cap nhat
        todo1.setTitle(todo.getTitle());
        todo1.setStatus(todo.getStatus());
        todoRepository.save(todo1);
        return ResponseEntity.ok(todo1);
    }

    @DeleteMapping("/api/v1/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Integer id) {
        //kiem tra id
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("not found");
                });
        todoRepository.delete(todo);
        return ResponseEntity.noContent().build();
    }
}
