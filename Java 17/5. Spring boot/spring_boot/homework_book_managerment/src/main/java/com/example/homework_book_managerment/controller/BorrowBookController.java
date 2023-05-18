package com.example.homework_book_managerment.controller;

import com.example.homework_book_managerment.model.Book;
import com.example.homework_book_managerment.model.BorrowBook;
import com.example.homework_book_managerment.model.Reader;
import com.example.homework_book_managerment.service.BookService;
import com.example.homework_book_managerment.service.BorrowBookService;
import com.example.homework_book_managerment.service.ReaderService;
import com.example.homework_book_managerment.statics.Status;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/borrows")
public class BorrowBookController {
    BorrowBookService borrowBookService;
    BookService bookService;
    ReaderService readerService;

    @GetMapping
    public String getAllBorrow(Model model) {
        List<BorrowBook> borrowBooks = borrowBookService.getAllBorrows();
        model.addAttribute("danhSachMuonBook", borrowBooks);
        return "borrow-book-list";
    }

    @GetMapping("/create-form")
    public String forwardCreateBorrowForm(Model model, BorrowBook borrowBook) {
        getSelect(model);

        model.addAttribute("themLuotMuon", borrowBook);
        return "create-borrow-book";
    }

    @PostMapping
    public String createNewBorrow(@ModelAttribute("themLuotMuon") @Valid BorrowBook borrowBook, Errors errors, Model model) {
        if (errors != null && errors.getErrorCount() > 0) {
            getSelect(model);

            return "create-borrow-book";
        }
        borrowBookService.createNewBorrow(borrowBook);
        return "redirect:/borrows";
    }

    @GetMapping("/update/{id}")
    public String forwardUpdateForm(@PathVariable int id, Model model) {
        BorrowBook borrowBook = borrowBookService.findBorrowById(id);
        getSelect(model);
        model.addAttribute("borrowCanUpdate", borrowBook);

        return "update-borrow-book";
    }

    @PostMapping("/update")
    public String updateBorrow(@ModelAttribute("borrowCanUpdate") BorrowBook borrowBook) {
        borrowBookService.updateBorrow(borrowBook);
        return "redirect:/borrows";
    }

    private void getSelect(Model model) {
        List<Book> books = bookService.getAllBooks();
        List<Reader> readers = readerService.getAllReaders();
        List<Status> statusList = Arrays.asList(Status.values());

        model.addAttribute("dsBook", books);
        model.addAttribute("dsReader", readers);
        model.addAttribute("dsStatus", statusList);
    }
}
