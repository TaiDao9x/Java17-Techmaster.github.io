package org.example;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        // sử dụng constructor
        Person person = new Person(1, "tai", "a@gmail.com",29);
        System.out.println(person);

        Person person1 = Person.builder()
                .email("B@gmail.com")
                .name("abc")
                .build();
        System.out.println(person1);

        // Tạo ra nhiều person
        Faker faker = new Faker();
        Person[] people = new Person[20];
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person(i + 1, faker.name().fullName(), faker.internet().emailAddress(),faker.hashCode());

        }

        for (Person p : people) {
            System.out.println(p);
        }

    }
}