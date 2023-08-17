package com.example.goodreads_finalproject.service;

import com.example.goodreads_finalproject.entity.*;
import com.example.goodreads_finalproject.exception.*;
import com.example.goodreads_finalproject.model.request.*;
import com.example.goodreads_finalproject.model.response.*;
import com.example.goodreads_finalproject.repository.*;
import com.example.goodreads_finalproject.repository.custom.BookCustomRepository;
import com.example.goodreads_finalproject.statics.ReadingStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookService {
    BookRepository bookRepository;
    UserRepository userRepository;
    CategoryService categoryService;
    ReadingBookRepository readingBookRepository;
    BookOfChallengeRepository bookOfChallengeRepository;
    ObjectMapper objectMapper;
    BookCustomRepository bookCustomRepository;


    public void createBook(BookRequest newBook) {
//        Set<Long> categoryId = newBook.getCategoryId().stream()
//                .map(Long::parseLong)
//                .collect(Collectors.toSet());
        Set<Category> categories = new HashSet<>();
        newBook.getCategoryId().forEach(id -> categories.add(categoryService.findById(id).get()));

        Book book = Book.builder()
                .image(newBook.getImage().equals("") ? "/original/images/books/no-cover.png" : newBook.getImage())
                .title(newBook.getTitle())
                .author(newBook.getAuthor())
                .buyBook(newBook.getBuyBook())
                .categories(categories)
                .description(newBook.getDescription())
                .published(newBook.getPublished())
                .buyBook(newBook.getBuyBook().equals("") ? "https://www.fahasa.com/" : newBook.getBuyBook())
                .build();
        bookRepository.save(book);
    }

    public void updateBook(BookRequest updateBookRequest) {
        Book book = bookRepository.findById(updateBookRequest.getBookId()).get();
        Set<Long> categoryIds = updateBookRequest.getCategoryId();
        Set<Category> categories = new HashSet<>();

        categoryIds.forEach(id -> categories.add(categoryService.findById(id).get()));

        if (!updateBookRequest.getImage().equals("")) {
            book.setImage(updateBookRequest.getImage());
        }

        if (!updateBookRequest.getBuyBook().equals("")) {
            book.setBuyBook(updateBookRequest.getBuyBook());
        }

        book.setTitle(updateBookRequest.getTitle());
        book.setAuthor(updateBookRequest.getAuthor());
        book.setCategories(categories);
        book.setDescription(updateBookRequest.getDescription());
        book.setPublished(updateBookRequest.getPublished());
        book.setRating(updateBookRequest.getRating());
        bookRepository.save(book);
    }


    public BookResponse findBookByBookId(Long bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isEmpty()) {
            throw new NotFoundException("Book not found!");
        }
        Book book = bookOptional.get();

        return objectMapper.convertValue(book, BookResponse.class);
    }

    public CommonResponse<?> searchBook(BookSearchRequest request) {
        try {
            List<BookResponse> books = bookCustomRepository.searchBook(request);
            Integer totalResult = books.size();

            Integer pageIndex = request.getPageIndex();
            Integer pageSize = request.getPageSize();

            PaginationUtils<BookResponse> paginationUtils = new PaginationUtils<>();
            int pageNumber = paginationUtils.getPageNumber(books, pageSize);
            books = paginationUtils.searchData(books, pageIndex, pageSize);


            return CommonResponse.builder()
                    .totalResult(totalResult)
                    .pageNumber(pageNumber)
                    .data(books)
                    .build();
        } catch (Exception e) {
            throw new NotFoundException("Page index out of bound");
        }
    }


    public CommonResponse<?> searchBookAuthen(BookSearchRequest request, Long userId) {
        try {
            List<BookResponse> books = bookCustomRepository.searchBookAuthen(request, userId);
            Integer totalResult = books.size();
            Integer pageIndex = request.getPageIndex();
            Integer pageSize = request.getPageSize();

            PaginationUtils<BookResponse> paginationUtils = new PaginationUtils<>();
            int pageNumber = paginationUtils.getPageNumber(books, pageSize);
            books = paginationUtils.searchData(books, pageIndex, pageSize);


            return CommonResponse.builder()
                    .totalResult(totalResult)
                    .pageNumber(pageNumber)
                    .data(books)
                    .build();
        } catch (Exception e) {
            throw new NotFoundException("Page index out of bound");
        }
    }

    public void markBook(ReadingBookRequest request) {
        Optional<Book> bookOptional = bookRepository.findById(request.getBookId());
        User user = userRepository.findById(request.getUserId()).get();
        if (bookOptional.isEmpty()) {
            throw new NotFoundException("Book not found!");
        }

        String status = request.getReadingStatus();
        ReadingStatus enumValue = null;
        for (ReadingStatus readingStatus : ReadingStatus.values()) {
            if (readingStatus.getName().equals(status)) {
                enumValue = readingStatus;
                break;
            }
        }
        if (enumValue == null) {
            throw new IllegalArgumentException("Invalid Reading Status!");
        }
        Optional<ReadingBook> readingBookOptional = readingBookRepository.findByUserAndBook(user, bookOptional.get());
        ReadingBook readingBook;
        if (readingBookOptional.isEmpty()) {
            readingBook = ReadingBook.builder()
                    .book(bookOptional.get())
                    .user(user)
                    .readingStatus(enumValue)
                    .build();
        } else {
            readingBook = readingBookOptional.get();
            readingBook.setReadingStatus(enumValue);
        }
        readingBookRepository.save(readingBook);
    }

    public CommonResponse<?> getMyBookPagination(ReadingBookRequest request) {
        Optional<User> userOptional = userRepository.findById(request.getUserId());
        if (userOptional.isEmpty()) {
            throw new NotFoundException("User not exist!");
        }
        List<ReadingBook> readingBooks = readingBookRepository.findAllByUser(userOptional.get());
        List<ReadingBookResponse> readingBookResponses = new ArrayList<>();
        for (ReadingBook readingBook : readingBooks) {
            readingBookResponses.add(
                    ReadingBookResponse.builder()
                            .book(readingBook.getBook())
                            .readingStatus(readingBook.getReadingStatus().getName())
                            .readingProgress(readingBook.getReadingProgress())
                            .addedDateTime(LocalDate.now())
                            .startedDateTime(readingBook.getStartedDateTime())
                            .finishedDateTime(readingBook.getFinishedDateTime())
                            .build());
        }

        Integer pageIndex = request.getPageIndex();
        Integer pageSize = request.getPageSize();
        PaginationUtils<ReadingBookResponse> paginationUtils = new PaginationUtils<>();
        int pageNumber = paginationUtils.getPageNumber(readingBookResponses, pageSize);
        readingBookResponses = paginationUtils.searchData(readingBookResponses, pageIndex, pageSize);

        return CommonResponse.builder()
                .pageNumber(pageNumber)
                .data(readingBookResponses)
                .build();
    }

    public List<Integer> countMyBookList(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new NotFoundException("User not exist!");
        }
        List<ReadingBook> readingBooks = readingBookRepository.findAllByUser(userOptional.get());
        List<Integer> result = new ArrayList<>();
        int countRead = 0;
        int countReading = 0;
        int countWantToRead = 0;
        for (ReadingBook readingBook : readingBooks) {
            switch (readingBook.getReadingStatus().getName()) {
                case "To-read" -> countWantToRead++;
                case "Reading" -> countReading++;
                case "Read" -> countRead++;
            }
        }
        int countAllMyBook = countRead + countReading + countWantToRead;
        result.add(countAllMyBook);
        result.add(countRead);
        result.add(countReading);
        result.add(countWantToRead);
        return result;
    }

    @Transactional
    public void deleteBook(Long bookId) throws BadRequestException {
        Book book = bookRepository.findById(bookId).get();
        readingBookRepository.findAllByBook(book);
        bookOfChallengeRepository.findAllByBook(book);

        if (readingBookRepository.findAllByBook(book).isPresent() || bookOfChallengeRepository.findAllByBook(book).isPresent()) {
            throw new BadRequestException();
        }
        bookCustomRepository.deleteBookCategories(bookId);
        bookRepository.deleteById(bookId);
    }

    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }

    public List<BookResponse> findRandomBooks() {
        List<Long> allIds = bookRepository.getAllIds();
        List<Long> randomNumbers = getRandomNumbers(allIds, 7);
        List<Book> randomBooks = bookRepository.findRandomBooks(randomNumbers);
        List<BookResponse> result = new ArrayList<>();
        randomBooks.forEach(book -> result.add(objectMapper.convertValue(book, BookResponse.class)));
        return result;
    }

    public List<Long> getRandomNumbers(List<Long> source, int count) {
        if (count > source.size()) {
            throw new IllegalArgumentException("Số lượng số ngẫu nhiên yêu cầu vượt quá số lượng số trong danh sách.");
        }
        List<Long> shuffledNumbers = new ArrayList<>(source);
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers.subList(0, count);
    }

}

