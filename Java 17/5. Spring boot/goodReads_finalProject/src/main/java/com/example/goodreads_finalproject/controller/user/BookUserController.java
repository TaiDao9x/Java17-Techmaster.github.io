package com.example.goodreads_finalproject.controller.user;

import com.example.goodreads_finalproject.entity.Book;
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
@RequestMapping("/users")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookUserController {
    BookService bookService;

//    @GetMapping("/books/{userId}")
//    public String getAllBooks(Model model, @PathVariable Long userId,
//                              @RequestParam(required = false, defaultValue = "1") Integer page,
//                              @RequestParam(required = false, defaultValue = "8") Integer pageSize) {
////        model.addAttribute("allBookUserInterested", bookService.getAllBooksUserInterested(userId));
//        Page<ReadingBookResponse> readingBookResponses = bookService.getAllBooksUserInterested(userId, page, pageSize);
//        return "user/my-book";
//    }

    @GetMapping("/books")
    public String findBook(Model model,
                           @RequestParam(required = false, defaultValue = "") String search,
                           @RequestParam(required = false, defaultValue = "") String searchType,
                           @RequestParam(required = false, defaultValue = "1") Integer page,
                           @RequestParam(required = false, defaultValue = "8") Integer pageSize) {
        Page<Book> book = bookService.findBook(search, searchType, page, pageSize);
        model.addAttribute("bookList", book);
        return "user/book-list";
    }

    @GetMapping("/books/{bookId}")
    public String findBook(Model model, @PathVariable Long bookId) {
        model.addAttribute("bookDetail", bookService.findBookByBookId(bookId));
        return "user/book-detail";
    }
}
