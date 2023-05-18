package com.example.homework_book_managerment.entity;

import com.example.homework_book_managerment.statics.ReaderType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ReaderEntity extends PersonEntity {
    private ReaderType readerType;

    public ReaderEntity(int id, String name, String address, String phone, ReaderType readerType) {
        super(id, name, address, phone);
        this.readerType = readerType;
    }

    public ReaderType getReaderType() {
        return readerType;
    }

    public void setReaderType(ReaderType readerType) {
        this.readerType = readerType;
    }
}
