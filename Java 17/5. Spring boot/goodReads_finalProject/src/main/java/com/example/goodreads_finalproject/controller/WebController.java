package com.example.goodreads_finalproject.controller;

import com.example.goodreads_finalproject.exception.OtpExpiredException;
import com.example.goodreads_finalproject.model.request.BookSearchRequest;
import com.example.goodreads_finalproject.model.response.CommonResponse;
import com.example.goodreads_finalproject.service.BookService;
import com.example.goodreads_finalproject.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WebController {
    UserService userService;
    BookService bookService;

    @GetMapping
    public String getHomePage(Model model) {
        return "user/index";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "account/login";
    }

    @GetMapping("/signup")
    public String getSignUpPage(Model model) {
        return "account/signup";
    }

    @GetMapping("/home")
    public String getPage(Model model) {
        return "user/home";
    }

    @GetMapping("/actived")
    public String getActivePage(@RequestParam("otpCode") String otpCode) {
        userService.activeAccount(otpCode);
        return "user/active-account";
    }

    @GetMapping("/check-otp-reset")
    public String getResetPasswordPage(@RequestParam("otpCode") String otpCode) {
        try {
            userService.checkOtp(otpCode);
            return "account/reset-password";
        } catch (OtpExpiredException e) {
            return "account/login";
        }
    }

    @GetMapping("/search")
    public CommonResponse<?> searchBook(BookSearchRequest request) {
        return bookService.searchBook(request);
    }
}
