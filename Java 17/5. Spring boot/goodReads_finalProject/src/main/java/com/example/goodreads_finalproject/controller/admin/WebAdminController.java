package com.example.goodreads_finalproject.controller.admin;

import com.example.goodreads_finalproject.entity.Book;
import com.example.goodreads_finalproject.exception.OtpExpiredException;
import com.example.goodreads_finalproject.model.response.BookResponse;
import com.example.goodreads_finalproject.service.BookService;
import com.example.goodreads_finalproject.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WebAdminController {
    BookService bookService;

    @GetMapping("/all-book")
    public String allBook(Model model,
                          @RequestParam(required = false, defaultValue = "1") Integer page,
                          @RequestParam(required = false, defaultValue = "5") Integer pageSize) {

        Page<Book> bookResponsePage = bookService.getAllBook(page, pageSize);
        model.addAttribute("pageBookInfo", bookResponsePage);
        model.addAttribute("currentPage", page);

        return "admin/all-book";
    }

    @GetMapping("/add-book")
    public String addBook(Model model) {
        model.addAttribute("listAllCategories", bookService.getAllCategories());
        return "admin/add-book";
    }

}
