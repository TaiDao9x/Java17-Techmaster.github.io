package com.example.goodreads_finalproject.controller.admin;

import com.example.goodreads_finalproject.exception.BadRequestException;
import com.example.goodreads_finalproject.model.request.CategoryRequest;
import com.example.goodreads_finalproject.model.request.CreateBookRequest;
import com.example.goodreads_finalproject.model.request.UpdateBookRequest;
import com.example.goodreads_finalproject.service.BookService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookAdminController {

    BookService bookService;

    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest newCategoryRequest) {
        bookService.createCategory(newCategoryRequest);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) throws BadRequestException {
        bookService.deleteCategory(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<?> createBook(@RequestBody CreateBookRequest newBook,
                                        @RequestParam("file") MultipartFile multipartFile) throws IOException {
        bookService.createBook(newBook,multipartFile);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping("/book")
    public ResponseEntity<?> updateBook(@RequestBody UpdateBookRequest updateBookRequest) {
        bookService.updateBook(updateBookRequest);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
