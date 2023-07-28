package com.example.goodreads_finalproject.controller.user;

import com.example.goodreads_finalproject.entity.Book;
import com.example.goodreads_finalproject.model.request.ReadingBookRequest;
import com.example.goodreads_finalproject.model.response.ReadingBookResponse;
import com.example.goodreads_finalproject.security.SecurityUtils;
import com.example.goodreads_finalproject.service.BookService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users/books")
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

    // TODO: tìm kiếm sách bên user, chưa authen, thay bằng method search mới
    @GetMapping()
    public ModelAndView findBook(Model model,
                                 @RequestParam(required = false, defaultValue = "") String search,
                                 @RequestParam(required = false, defaultValue = "") String searchType,
                                 @RequestParam(required = false, defaultValue = "1") Integer page,
                                 @RequestParam(required = false, defaultValue = "8") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView("user/book-list");
        Page<Book> book = bookService.findBook(search, searchType, page, pageSize);
        modelAndView.addObject("bookList", book);
        return modelAndView;
    }

    @GetMapping("/{bookId}")
    public ModelAndView getBookDetail(Model model, @PathVariable Long bookId) {
        ModelAndView modelAndView = new ModelAndView("user/book-detail");
        modelAndView.addObject("bookDetail", bookService.findBookByBookId(bookId));
        return modelAndView;
    }

    @PostMapping("/book-reading")
    public ResponseEntity<?> markBook(@RequestBody ReadingBookRequest request) {
        bookService.markBook(request);
        return new ResponseEntity<>("Successful", HttpStatus.CREATED);
    }

    @GetMapping("/book-reading")
    public ResponseEntity<?> getMyBook() {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();
        if (userIdOptional.isEmpty()) {
            throw new UsernameNotFoundException("Tài khoản không tồn tại");
        }

        return ResponseEntity.ok(
                bookService.getMyBook(ReadingBookRequest.builder()
                        .userId(userIdOptional.get())
                        .build()));
    }
}
