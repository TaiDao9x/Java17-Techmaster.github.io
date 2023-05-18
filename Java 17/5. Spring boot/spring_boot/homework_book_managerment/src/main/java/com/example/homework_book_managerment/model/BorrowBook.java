package com.example.homework_book_managerment.model;

import com.example.homework_book_managerment.statics.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BorrowBook {
    int id;

    int idReader;
    String readerName;

    int idBook;
    String bookName;

    @NotNull(message = "Số lượng mượn không được trống!")
    @Range(min = 1, max = 3, message = "Số lượng trong khoảng từ 1 đến 3")
    int quantity;
    Status status;

    @NotNull(message = "Ngày mượn không được trống!")
    @PastOrPresent(message = "Ngày mượn phải trước bằng ngày hôm nay!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
}
