package com.example.goodreads_finalproject.controller.user;

import com.example.goodreads_finalproject.model.response.ReadingBookResponse;
import com.example.goodreads_finalproject.service.BookService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookUserController {
    BookService bookService;

    @GetMapping("/users/books/{userId}")
    public String getAllBooks(Model model, @PathVariable Long userId,
                              @RequestParam(required = false, defaultValue = "1") Integer page,
                              @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
//        model.addAttribute("allBookUserInterested", bookService.getAllBooksUserInterested(userId));
        Page<ReadingBookResponse> readingBookResponses = bookService.getAllBooksUserInterested(userId, page, pageSize);
        return "user/my-book";
    }
}