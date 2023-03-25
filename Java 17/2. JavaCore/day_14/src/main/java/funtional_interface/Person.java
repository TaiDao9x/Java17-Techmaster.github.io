package funtional_interface;

import java.sql.SQLOutput;

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class Person implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Xin chào: " + name);
    }

    public static void main(String[] args) {
        // Cách 1: sử dụng class cụ thể
        Greeting greeting = new Person();
        greeting.sayHello("Tài");

        // Cách 2: sử dụng anonymous clas
        Greeting greeting1 = new Greeting() {
            @Override
            public void sayHello(String name) {
                System.out.println("chào:" + name);
            }
        };
        greeting1.sayHello("A");

        // Cách 3 sử dụng lambda
        Greeting greeting2 = (name) -> System.out.println("Konichiwa " + name);

        greeting2.sayHello("Trần B");
    }
}
