package com.example.goodreads_finalproject.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HomeController {

    @GetMapping
    public String getHomePage(Model model) {
        return "anonymous/index";
    }
    @GetMapping("/contact")
    public String getContactPage(Model model) {
        return "contact";
    }
    @GetMapping("/product-detail")
    public String getDetailPage(Model model) {
        return "product-detail";
    }
    @GetMapping("/product-listing")
    public String getListingPage(Model model) {
        return "product-listing";
    }
    @GetMapping("/shop-cart")
    public String getShopPage(Model model) {
        return "shop-cart";
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
}
