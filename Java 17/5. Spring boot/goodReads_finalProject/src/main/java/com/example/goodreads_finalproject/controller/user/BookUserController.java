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

@Controller
@RequestMapping("/api/v1/users/books")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookUserController {


}
