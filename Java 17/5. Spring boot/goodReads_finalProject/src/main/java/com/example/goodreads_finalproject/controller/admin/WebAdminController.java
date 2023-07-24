package com.example.goodreads_finalproject.controller.admin;

import com.example.goodreads_finalproject.exception.OtpExpiredException;
import com.example.goodreads_finalproject.service.BookService;
import com.example.goodreads_finalproject.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
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

    @GetMapping("/allBook")
    public String allBook(Model model,
                          @RequestParam(required = false, defaultValue = "1") Integer page,
                          @RequestParam(required = false, defaultValue = "6") Integer pageSize) {

        Page<>
        return "admin/all-book";
    }

    @GetMapping("/addBook")
    public String addBook(Model model) {
        model.addAttribute("listAllCategories", bookService.getAllCategories());
        return "admin/add-book";
    }
}
