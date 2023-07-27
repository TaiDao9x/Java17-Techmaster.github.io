package com.example.goodreads_finalproject.service;

import com.example.goodreads_finalproject.entity.*;
import com.example.goodreads_finalproject.exception.*;
import com.example.goodreads_finalproject.model.request.*;
import com.example.goodreads_finalproject.model.response.*;
import com.example.goodreads_finalproject.repository.*;
import com.example.goodreads_finalproject.repository.custom.BookCustomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    BookCustomRepository bookCustomRepository;

    public void createBook(CreateBookRequest newBook) {
        Set<Long> categoryId = newBook.getCategoryId().stream()
                .map(Long::parseLong)
                .collect(Collectors.toSet());
        Set<Category> categories = new HashSet<>();
        categoryId.forEach(id -> categories.add(categoryRepository.findById(id).get()));

        Book book = Book.builder()
                .image(newBook.getImage().equals("") ? "/original/images/books/no-cover.png" : newBook.getImage())
                .title(newBook.getTitle())
                .author(newBook.getAuthor())
                .buyBook(newBook.getBuyBook())
                .categories(categories)
                .description(newBook.getDescription())
                .published(newBook.getPublished())
                .build();
        bookRepository.save(book);
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

    public void updateBook(UpdateBookRequest updateBookRequest) {
        Book book = bookRepository.findById(updateBookRequest.getBookId()).get();
        Set<Long> categoryIds = updateBookRequest.getCategoryId();
        Set<Category> categories = new HashSet<>();

        categoryIds.forEach(id -> categories.add(categoryRepository.findById(id).get()));

        String imageLink = updateBookRequest.getImage();
        if (updateBookRequest.getImage().equals("")) {
            imageLink = "/original/images/books/no-cover.png";
        }

        book.setImage(imageLink);
        book.setTitle(updateBookRequest.getTitle());
        book.setAuthor(updateBookRequest.getAuthor());
        book.setBuyBook(updateBookRequest.getBuyBook());
        book.setCategories(categories);
        book.setDescription(updateBookRequest.getDescription());
        book.setPublished(updateBookRequest.getPublished());
        book.setRating(updateBookRequest.getRating());
        bookRepository.save(book);
    }

    //TODO: Ko search ra được
    public Page<Book> findBook(String keyWord, String searchType, Integer page, Integer pageSize) {
        Pageable pageRequest = PageRequest.of(page - 1, pageSize);
        return switch (searchType) {
            case "" -> bookRepository.findAllByTitleOrAuthorContainingIgnoreCase(keyWord, keyWord, pageRequest);
            case "title" -> bookRepository.findAllByTitleContainingIgnoreCase(keyWord, pageRequest);
            case "author" -> bookRepository.findAllByAuthorContainingIgnoreCase(keyWord, pageRequest);
            default -> bookRepository.findAllByTitleOrAuthorContainingIgnoreCase(null, null, pageRequest);
        };

    }


    //category
    public void createCategory(CategoryRequest newCategoryRequest) {
        Category category = Category.builder()
                .name(newCategoryRequest.getCategory())
                .build();
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) throws BadRequestException {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new NotFoundException("Not found category");
        }
        List<Book> bookList = bookRepository.findAllByCategories(categoryOptional.get());
        if (bookList.size() > 0) {
            throw new BadRequestException();
        }
        categoryRepository.deleteById(id);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Page<Book> getAllBook(Integer page, Integer pageSize) {
        Pageable pageRequest = PageRequest.of(page - 1, pageSize);
        return bookRepository.findAll(pageRequest);
    }

    public Book findBookByBookId(Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isEmpty()) {
            throw new NotFoundException("Book not found!");
        }
        return bookOptional.get();
    }

    public CommonResponse<?> searchBook(BookSearchRequest request) {
        try {
            List<BookSearchResponse> books = bookCustomRepository.searchBook(request);
            Integer pageIndex = request.getPageIndex();
            Integer pageSize = request.getPageSize();

            int pageNumber = (int) Math.ceil((float) books.size() / pageSize);

            PaginationUtils<BookSearchResponse> paginationUtils = new PaginationUtils<>();
            books = paginationUtils.searchData(books, pageIndex, pageSize);

            return CommonResponse.builder()
                    .pageNumber(pageNumber)
                    .data(books)
                    .build();
        } catch (Exception e) {
            throw new NotFoundException("Page index out of bound");
        }
    }
}
