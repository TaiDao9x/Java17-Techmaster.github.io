package com.example.homework_book_managerment.controller;

import com.example.homework_book_managerment.model.Book;
import com.example.homework_book_managerment.service.BookService;
import com.example.homework_book_managerment.statics.Specialized;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {
    BookService bookService;

    @GetMapping
    public String getBook(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("danhSachBook", books);
        return "book-list";
    }

    @GetMapping("/create-form")
    public String fowardToCreateUserForm(Model model, Book book) {
        List<Specialized> specializeds = new ArrayList<>(Arrays.asList(Specialized.values()));
        model.addAttribute("dsChuyenNganh", specializeds);

        model.addAttribute("bookMuonTaoMoi", book);
        return "create-book";
    }

    @PostMapping
    public String createNewBook(@ModelAttribute("bookMuonTaoMoi") @Valid Book book, Errors errors, Model model) {
        if (errors != null && errors.getErrorCount() > 0) {
            List<Specialized> specializeds = new ArrayList<>(Arrays.asList(Specialized.values()));
            model.addAttribute("dsChuyenNganh", specializeds);
            return "create-book";
        }
        bookService.createNewBook(book);
        return "redirect:/books";
    }

    @GetMapping("/update/{id}")
    public String forwadUpdateForm(@PathVariable int id, Model model) {
        Book book = bookService.getBookById(id);

        List<Specialized> specializeds = new ArrayList<>(Arrays.asList(Specialized.values()));
        model.addAttribute("dsChuyenNganh", specializeds);

        model.addAttribute("bookMuonSua", book);
        return "update-book";
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute("bookMuonSua") @Valid Book book, Errors errors, Model model) {
        if (errors != null && errors.getErrorCount() > 0) {
            List<Specialized> specializeds = new ArrayList<>(Arrays.asList(Specialized.values()));
            model.addAttribute("dsChuyenNganh", specializeds);
            return "update-book";
        }
        bookService.updateBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
