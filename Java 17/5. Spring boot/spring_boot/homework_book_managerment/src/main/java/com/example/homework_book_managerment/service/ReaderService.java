package com.example.homework_book_managerment.service;

import com.example.homework_book_managerment.model.Reader;
import com.example.homework_book_managerment.statics.ReaderType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReaderService {
    private static final List<Reader> readers = new ArrayList<>();
    private static int AUTO_ID = 10005;

    static {
        for (int i = 0; i < 5; i++) {
            Reader reader = new Reader(1 + i, "Nguyen Van " + i, "HN", "09000321" + i + 1, ReaderType.TEACHER);
            readers.add(reader);
        }
    }

    public List<Reader> getAllReaders() {
        return readers;
    }


    public void createNewReader(Reader reader) {
        reader.setId(AUTO_ID);
        AUTO_ID++;
        readers.add(reader);
    }

    public Reader getReaderById(int id) {
        for (Reader b : readers) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    public void updateReader(Reader reader) {
        Reader readerUpdate = getReaderById(reader.getId());
        readerUpdate.setName(reader.getName());
        readerUpdate.setAddress(reader.getAddress());
        readerUpdate.setPhone(reader.getPhone());
        readerUpdate.setReaderType(reader.getReaderType());
    }

    public void deleteReader(int id) {
        readers.removeIf(b -> b.getId() == id);
    }

}
