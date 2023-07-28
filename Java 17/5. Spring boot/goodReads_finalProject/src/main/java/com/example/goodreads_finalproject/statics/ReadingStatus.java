package com.example.goodreads_finalproject.statics;

import lombok.Getter;

@Getter
public enum ReadingStatus {
    WANT_TO_READ("Want to read"), READING("Reading"), READ("Read");

    String name;

    ReadingStatus(String name) {
        this.name = name;
    }
}
