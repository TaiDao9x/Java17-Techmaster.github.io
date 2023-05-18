package com.example.homework_book_managerment.model;

import com.example.homework_book_managerment.statics.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowBook {
    private int id;
    private Reader reader;
    private Book book;

    @NotNull(message = "Số lượng mượn không được trống!")
    @Range(min = 1, max = 3, message = "Số lượng trong khoảng từ 1 đến 3")
    private int quantity;
    private Status status;

    @NotNull(message = "Ngày mượn không được trống!")
    @PastOrPresent(message = "Ngày mượn phải trước bằng ngày hôm nay!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
