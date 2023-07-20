package com.example.goodreads_finalproject.controller.admin;

import com.example.goodreads_finalproject.exception.ExistedUserException;
import com.example.goodreads_finalproject.model.request.CategoryRequest;
import com.example.goodreads_finalproject.model.request.CreateBookRequest;
import com.example.goodreads_finalproject.model.request.CreateUserRequest;
import com.example.goodreads_finalproject.model.response.UserResponse;
import com.example.goodreads_finalproject.service.BookService;
import com.example.goodreads_finalproject.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdminController {

    BookService bookService;

    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest newCategoryRequest) {
        bookService.createCategory(newCategoryRequest);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping("/book")
    public ResponseEntity<?> createBook(@RequestBody CreateBookRequest newBook) {
        bookService.createBook(newBook);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }


}
