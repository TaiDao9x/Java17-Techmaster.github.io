package arraylist_demo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(1);
        System.out.println(numbers);

        // Method
        numbers.add(0, 10);
        System.out.println(numbers);

        ArrayList<Integer> numbers1 = new ArrayList<>(List.of(100, 200, 300));
        numbers.addAll(numbers1);
        System.out.println(numbers1);

        System.out.println(numbers.contains(100));

        System.out.println(numbers.get(0));


        ArrayList<String> names = new ArrayList<>(List.of("Tài", "An"));
        System.out.println(names);


    }
}
