package com.example.student_mvc.statics;

public enum Level {
    PROFESSOR("Professor"), DOCTOR("Doctor"), MASTER("Master");

    public String name;

    Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}