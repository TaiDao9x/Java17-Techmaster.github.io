package com.example.goodreads_finalproject.service;

import com.example.goodreads_finalproject.entity.*;
import com.example.goodreads_finalproject.exception.*;
import com.example.goodreads_finalproject.model.request.*;
import com.example.goodreads_finalproject.model.response.JwtResponse;
import com.example.goodreads_finalproject.model.response.ReadingBookResponse;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    UserRepository userRepository;
    CategoryRepository categoryRepository;
    ReadingBookRepository readingBookRepository;
    ObjectMapper objectMapper;

    public void createBook(CreateBookRequest newBook) {
        Set<Long> categoryId = newBook.getCategoryId();
        Set<Category> categories = new HashSet<>();
        categoryId.forEach(id -> categories.add(categoryRepository.findById(id).get()));

        Book book = Book.builder()
                .image(newBook.getImage())
                .title(newBook.getTitle())
                .author(newBook.getAuthor())
                .buyBook(newBook.getBuyBook())
                .categories(categories)
                .description(newBook.getDescription())
                .published(newBook.getPublished())
                .build();
        bookRepository.save(book);
    }

    public void createCategory(CategoryRequest newCategoryRequest) {
        Category category = Category.builder()
                .category(newCategoryRequest.getCategory())
                .build();
        categoryRepository.save(category);
    }

    public Page<ReadingBookResponse> getAllBooksUserInterested(Long userId, Integer page, Integer pageSize) {
        Pageable pageRequest = PageRequest.of(page - 1, pageSize);
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new NotFoundException("Not found user!");
        }
        Page<ReadingBook> readingBooksPage = readingBookRepository.findAllByUser(userOptional.get(), pageRequest);
        if (readingBooksPage == null) {
            throw new NotFoundException("Not found book!");
        }
        List<ReadingBookResponse> responseList = new ArrayList<>();

        for (ReadingBook readingBook : readingBooksPage.getContent()) {
            responseList.add(objectMapper.convertValue(readingBook, ReadingBookResponse.class));
        }

        return new PageImpl<>(responseList, pageRequest, readingBooksPage.getTotalElements());
    }
}

