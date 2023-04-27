package org.example;

import demo_lombok.Student;
import org.apache.log4j.Logger;

public class Main {

    static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Student student1 = Student.builder().id(5).address("HN").build();

//        System.out.println(student1);
        log.warn(student1);

    }
}