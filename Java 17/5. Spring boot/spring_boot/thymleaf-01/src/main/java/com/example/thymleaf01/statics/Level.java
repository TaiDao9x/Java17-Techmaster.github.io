package com.example.thymleaf01.statics;

public enum Level {
    PROFESSOR(1, "Professor"), DOCTOR(2, "Doctor"), MASTER(3, "Master");

    public int id;
    public String name;

    Level(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
