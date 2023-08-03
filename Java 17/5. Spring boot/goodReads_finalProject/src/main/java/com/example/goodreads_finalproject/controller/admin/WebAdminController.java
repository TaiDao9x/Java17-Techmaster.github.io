package com.example.goodreads_finalproject.controller.admin;

import com.example.goodreads_finalproject.model.request.BookSearchRequest;
import com.example.goodreads_finalproject.model.response.CommonResponse;
import com.example.goodreads_finalproject.service.BookService;
import com.example.goodreads_finalproject.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WebAdminController {
    BookService bookService;
    UserService userService;

    @GetMapping("/books")
    public String allBook(Model model, BookSearchRequest request) {

        model.addAttribute("pageBookInfo", getBookData(request));
        model.addAttribute("currentPage", request.getPageIndex());

        return "admin/all-books";
    }
//
//    @GetMapping("/books")
//    public CommonResponse<?> allBook(Model model, BookSearchRequest request) {
//
//        model.addAttribute("pageBookInfo", getBookData(request));
//        model.addAttribute("currentPage", request.getPageIndex());
//
//        return getBookData(request);
//    }

    private CommonResponse<?> getBookData(BookSearchRequest request) {
        return bookService.searchBook(request);
    }

    @GetMapping("/add-book")
    public String addBook(Model model) {
        model.addAttribute("listAllCategories", bookService.getAllCategories());
        return "admin/add-book";
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
}
