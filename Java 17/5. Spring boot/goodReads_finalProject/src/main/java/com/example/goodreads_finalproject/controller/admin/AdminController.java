package com.example.goodreads_finalproject.controller.admin;

import com.example.goodreads_finalproject.exception.ExistedUserException;
import com.example.goodreads_finalproject.model.request.CreateUserRequest;
import com.example.goodreads_finalproject.model.request.UserSearchRequest;
import com.example.goodreads_finalproject.model.response.CommonResponse;
import com.example.goodreads_finalproject.service.BookService;
import com.example.goodreads_finalproject.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping()
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdminController {
    BookService bookService;
    UserService userService;

    @GetMapping("/admin/users")
    public String searchUser(Model model, UserSearchRequest request) {
        CommonResponse<?> commonResponse = userService.searchCategory(request);

        model.addAttribute("pageCategoryInfo", commonResponse);
        model.addAttribute("currentPage", request.getPageIndex());
        model.addAttribute("pageSize", request.getPageSize());

        return "admin/category/category-list";
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserRequest request) {
        try {
            userService.createUser(request);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (ExistedUserException ex) {
            return new ResponseEntity<>("Email existed", HttpStatus.BAD_REQUEST);
        }
    }

}

