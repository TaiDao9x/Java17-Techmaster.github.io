package com.example.homework_book_managerment.entity;

import com.example.homework_book_managerment.statics.ReaderType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReaderEntity extends PersonEntity {
    ReaderType readerType;

    public ReaderEntity(int id, String name, String address, String phone, ReaderType readerType) {
        super(id, name, address, phone);
        this.readerType = readerType;
    }
}
