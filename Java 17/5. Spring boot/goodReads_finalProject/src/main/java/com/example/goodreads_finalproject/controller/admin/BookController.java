package com.example.goodreads_finalproject.controller.admin;

import com.example.goodreads_finalproject.exception.BadRequestException;
import com.example.goodreads_finalproject.model.request.BookSearchRequest;
import com.example.goodreads_finalproject.model.request.CategoryRequest;
import com.example.goodreads_finalproject.model.request.CreateBookRequest;
import com.example.goodreads_finalproject.model.request.UpdateBookRequest;
import com.example.goodreads_finalproject.model.response.CommonResponse;
import com.example.goodreads_finalproject.service.BookService;
import com.example.goodreads_finalproject.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {
    BookService bookService;
    UserService userService;

    @GetMapping("/admin/books")
    public String allBook(Model model, BookSearchRequest request) {
        CommonResponse<?> commonResponse = bookService.searchBook(request);
        model.addAttribute("pageBookInfo", commonResponse);
        model.addAttribute("currentPage", request.getPageIndex());
        model.addAttribute("pageSize", request.getPageSize());
        return "admin/book/book-list";
    }

    @GetMapping("/admin/add-book")
    public String addBook(Model model) {
        model.addAttribute("categoryList", bookService.getAllCategories());
        return "admin/book/book-create";
    }

    @GetMapping("/admin/books/{bookId}")
    public String editBook(Model model, @PathVariable Long bookId) {
        model.addAttribute("bookDetails", bookService.findBookByBookId(bookId));
        model.addAttribute("categoryList", bookService.getAllCategories());
        return "admin/book/book-edit";
    }

//    @PostMapping
//    public ResponseEntity<?> create(@RequestBody @Valid CreateUserRequest request) {
//        try {
//            userService.createUser(request);
//            return ResponseEntity.ok(null);
//        } catch (ExistedUserException ex) {
//            return new ResponseEntity<>("Email existed", HttpStatus.BAD_REQUEST);
//        }
//    }

    @PostMapping("/api/v1/admin/book")
    public ResponseEntity<?> createBook(@RequestBody CreateBookRequest newBook) {
        bookService.createBook(newBook);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/admin/book")
    public ResponseEntity<?> updateBook(@RequestBody UpdateBookRequest updateBookRequest) {
        bookService.updateBook(updateBookRequest);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/admin/book/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId) throws BadRequestException {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
