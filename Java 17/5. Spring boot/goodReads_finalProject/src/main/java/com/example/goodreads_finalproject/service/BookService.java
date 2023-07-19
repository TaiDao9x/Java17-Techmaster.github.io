package com.example.goodreads_finalproject.service;

import com.example.goodreads_finalproject.entity.*;
import com.example.goodreads_finalproject.exception.*;
import com.example.goodreads_finalproject.model.request.*;
import com.example.goodreads_finalproject.model.response.JwtResponse;
import com.example.goodreads_finalproject.model.response.UserResponse;
import com.example.goodreads_finalproject.repository.*;
import com.example.goodreads_finalproject.security.CustomUserDetails;
import com.example.goodreads_finalproject.security.JwtUtils;
import com.example.goodreads_finalproject.security.SecurityUtils;
import com.example.goodreads_finalproject.statics.Roles;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookService {
    BookRepository bookRepository;
    CategoryRepository categoryRepository;

//    public void createBook(CreateBookRequest newBook) {
//        Set<Long> categoryId = newBook.getCategoryId();
//        Set<Category> categories = new HashSet<>();
//        categoryId.forEach(categoryId->categoryRepository.findById(categoryId));
//
//        Book book = Book.builder()
//                .image(newBook.getImage())
//                .title(newBook.getTitle())
//                .author(newBook.getAuthor())
//                .buyBook(newBook.getBuyBook())
//                .categories()
//                .description(newBook.getDescription())
//                .published(newBook.getPublished())
//                .build();
//        bookRepository.save(book);
//    }
//
//    public void createCategory(CategoryRequest newCategoryRequest) {
//        Category category = Category.builder()
//                .category(newCategoryRequest.getCategory())
//                .build();
//        categoryRepository.save(category);
//    }
}
