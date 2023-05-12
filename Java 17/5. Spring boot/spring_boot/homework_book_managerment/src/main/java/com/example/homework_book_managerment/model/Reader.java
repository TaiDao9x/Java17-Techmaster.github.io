package com.example.homework_book_managerment.model;

import com.example.homework_book_managerment.statics.ReaderType;
import lombok.*;

//@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Reader extends Person {
    private ReaderType readerType;

    public Reader(int id, String name, String address, String phone, ReaderType readerType) {
        super(id, name, address, phone);
        this.readerType = readerType;
    }
}
