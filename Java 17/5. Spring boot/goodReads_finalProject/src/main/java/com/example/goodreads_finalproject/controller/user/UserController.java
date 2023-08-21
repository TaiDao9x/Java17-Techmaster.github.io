package com.example.goodreads_finalproject.controller.user;

import com.example.goodreads_finalproject.exception.BadRequestException;
import com.example.goodreads_finalproject.exception.NotFoundException;
import com.example.goodreads_finalproject.model.request.*;
import com.example.goodreads_finalproject.model.response.BookResponse;
import com.example.goodreads_finalproject.model.response.LocationResponse;
import com.example.goodreads_finalproject.security.SecurityUtils;
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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;
    BookService bookService;

    // Thymleaf
    @GetMapping("/users/my-book")
    public String getMyBookPage(Model model) {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();

        model.addAttribute("myBookList", bookService.getMyBookPagination(ReadingBookRequest.builder()
                .userId(userIdOptional.get())
                .build()));
        model.addAttribute("countMyBookList", bookService.countMyBookList(userIdOptional.get()));
        return "user/my-book";
    }

    @GetMapping("/users/review/{bookId}")
    public String getReviewPage(Model model, @PathVariable Long bookId) {
        Optional<Long> optionalId = SecurityUtils.getCurrentUserLoginId();
        BookResponse bookResponse = bookService.findBookByBookId(bookId, optionalId.get());
        model.addAttribute("bookDetail", bookResponse);

        return "user/review-detail";
    }

    // API

    @PostMapping("/api/v1/users/book-reading")
    public ResponseEntity<?> markBook(@RequestBody ReadingBookRequest request) {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();
        if (userIdOptional.isEmpty()) {
            throw new NotFoundException("not found user");
        }
        request.setUserId(userIdOptional.get());
        bookService.markBook(request);
        return new ResponseEntity<>("Successful", HttpStatus.CREATED);
    }

    @DeleteMapping("/api/v1/users/book-reading/{bookId}")
    public ResponseEntity<?> removeMarkBook(@PathVariable Long bookId) {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();
        if (userIdOptional.isEmpty()) {
            throw new NotFoundException("not found user");
        }
        bookService.removeMarkBook(bookId, userIdOptional.get());
        return new ResponseEntity<>("Successful", HttpStatus.CREATED);
    }

    // Rating
    @PostMapping("/api/v1/users/rating")
    public ResponseEntity<?> changeRating(@RequestBody @Valid ReviewRequest request) {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();
        if (userIdOptional.isEmpty()) {
            throw new NotFoundException("not found user");
        }
        bookService.changeRating(request, userIdOptional.get());
        return new ResponseEntity<>("Successful", HttpStatus.CREATED);
    }

    @DeleteMapping("/api/v1/users/rating/{bookId}")
    public ResponseEntity<?> removeRating(@PathVariable Long bookId) {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();
        if (userIdOptional.isEmpty()) {
            throw new NotFoundException("not found user");
        }
        bookService.removeRating(bookId, userIdOptional.get());
        return new ResponseEntity<>("Successful", HttpStatus.CREATED);
    }

    // Review
    @PostMapping("/api/v1/users/review")
    public ResponseEntity<?> createReview(@RequestBody @Valid ReviewRequest request) {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();
        if (userIdOptional.isEmpty()) {
            throw new NotFoundException("not found user");
        }
        bookService.saveReview(request, userIdOptional.get());
        return new ResponseEntity<>("Successful", HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/users/review")
    public ResponseEntity<?> updateReview(@RequestBody @Valid ReviewRequest request) {
        Optional<Long> userIdOptional = SecurityUtils.getCurrentUserLoginId();
        if (userIdOptional.isEmpty()) {
            throw new NotFoundException("not found user");
        }
        bookService.saveReview(request, userIdOptional.get());
        return new ResponseEntity<>("Successful", HttpStatus.OK);
    }

    // Address
    @GetMapping("/api/v1/users/districts/{provinceCode}")
    public ResponseEntity<?> getDistricts(@PathVariable String provinceCode) {
        try {
            List<LocationResponse> districts = userService.getDistricts(provinceCode);
            return new ResponseEntity<>(districts, HttpStatus.OK);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/v1/users/wards/{districtCode}")
    public ResponseEntity<?> getWards(@PathVariable String districtCode) {
        try {
            List<LocationResponse> wards = userService.getWards(districtCode);
            return new ResponseEntity<>(wards, HttpStatus.OK);
        } catch (BadRequestException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/api/v1/users/address")
    public ResponseEntity<?> updateAddress(@RequestBody WardRequest wardRequest) {
        userService.updateAddress(wardRequest);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
