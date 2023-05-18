package com.example.homework_book_managerment.statics;

public enum Status {
    NEW("New"), LIKE_NEW("Like new"), VERY_GOOD("Very good"), GOOD("Good"), ACCEPTABLE("Acceptable");

    String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
