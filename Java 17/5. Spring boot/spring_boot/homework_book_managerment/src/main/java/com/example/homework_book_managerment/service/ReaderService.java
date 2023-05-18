package com.example.homework_book_managerment.service;

import com.example.homework_book_managerment.entity.ReaderEntity;
import com.example.homework_book_managerment.model.Reader;
import com.example.homework_book_managerment.statics.ReaderType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReaderService {
    ObjectMapper objectMapper;

    private static final List<ReaderEntity> readers = new ArrayList<>();
    private static int AUTO_ID = 10005;

    static {
        for (int i = 10000; i < 10005; i++) {
            ReaderEntity reader = new ReaderEntity(i, "Nguyen Van " + i, "HN", "09000" + (i + 1), ReaderType.TEACHER);
            readers.add(reader);
        }
    }

    public List<Reader> getAllReaders() {
        List<Reader> rs = new ArrayList<>();
        readers.forEach(r -> {
            Reader reader = objectMapper.convertValue(r, Reader.class);
            rs.add(reader);
        });
        return rs;
    }

    public void createNewReader(Reader reader) {
        ReaderEntity readerEntity = objectMapper.convertValue(reader, ReaderEntity.class);
        readerEntity.setId(AUTO_ID);
        AUTO_ID++;
        readers.add(readerEntity);
    }

    public Reader getReaderById(int id) {
        for (ReaderEntity readerEntity : readers) {
            if (readerEntity.getId() == id) return objectMapper.convertValue(readerEntity, Reader.class);
        }
        return null;
    }

    public void updateReader(Reader reader) {
        readers.forEach(readerUpdate -> {
            if (readerUpdate.getId() != reader.getId()) return;
            readerUpdate.setName(reader.getName());
            readerUpdate.setAddress(reader.getAddress());
            readerUpdate.setPhone(reader.getPhone());
            readerUpdate.setReaderType(reader.getReaderType());
        });

    }

    public void deleteReader(int id) {
        readers.removeIf(b -> b.getId() == id);
    }
}
