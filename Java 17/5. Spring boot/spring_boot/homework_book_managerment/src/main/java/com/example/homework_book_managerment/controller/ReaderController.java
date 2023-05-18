package com.example.homework_book_managerment.controller;

import com.example.homework_book_managerment.model.Reader;
import com.example.homework_book_managerment.service.ReaderService;
import com.example.homework_book_managerment.statics.ReaderType;
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
@RequestMapping("/readers")
public class ReaderController {
    ReaderService readerService;

    @GetMapping
    public String getAllReader(Model model) {
        List<Reader> readers = readerService.getAllReaders();
        model.addAttribute("danhSachReader", readers);
        return "reader-list";
    }

    @GetMapping("/create-form")
    public String forwardCreateForm(Model model, Reader reader) {
        List<ReaderType> readerTypes = Arrays.asList(ReaderType.values());
        model.addAttribute("dsLoaiReader", readerTypes);

        model.addAttribute("readerMuonTaoMoi", reader);
        return "create-reader";
    }

    @PostMapping
    public String createNewReader(@ModelAttribute("readerMuonTaoMoi") @Valid Reader reader, Errors errors, Model model) {
        if (errors != null && errors.getErrorCount() > 0) {
            List<ReaderType> readerTypes = Arrays.asList(ReaderType.values());
            model.addAttribute("dsLoaiReader", readerTypes);
            return "create-reader";
        }
        readerService.createNewReader(reader);
        return "redirect:/readers";
    }

    @GetMapping("/update/{id}")
    public String forwardUpdateForm(@PathVariable int id, Model model) {
        List<ReaderType> readerTypes = Arrays.asList(ReaderType.values());
        model.addAttribute("dsLoaiReader", readerTypes);

        Reader reader = readerService.getReaderById(id);
        model.addAttribute("readerMuonSua", reader);
        return "update-reader";
    }

    @PostMapping("/update")
    public String updateReader(@ModelAttribute Reader reader) {
        readerService.updateReader(reader);
        return "redirect:/readers";
    }

    @GetMapping("/delete/{id}")
    public String deleteReader(@PathVariable int id) {
        readerService.deleteReader(id);
        return "redirect:/readers";
    }


}
