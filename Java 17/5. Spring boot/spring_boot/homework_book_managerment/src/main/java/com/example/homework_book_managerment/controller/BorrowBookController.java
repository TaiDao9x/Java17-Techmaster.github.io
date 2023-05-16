package com.example.homework_book_managerment.controller;

import com.example.homework_book_managerment.model.BorrowBook;
import com.example.homework_book_managerment.service.BorrowBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/borrows")
public class BorrowBookController {
    BorrowBookService borrowBookService;

    @GetMapping
    public String getAllBorrow(Model model) {
        List<BorrowBook> borrowBooks = borrowBookService.getAllBorrows();
        model.addAttribute("danhSachMuonBook", borrowBooks);
        return "borrow-book-list";
    }
}
