package funtional_interface_builtin;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo<T> {
    public static void main(String[] args) {

//        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30, 40, 31, 52, 60, 63, 31, 21));
//
////        numbers.removeIf(number -> number > 30);
////        System.out.println(numbers);
//
//        Predicate<Integer> predicate = item -> item > 30;
//        Predicate<Integer> predicate1 = item -> item % 2 == 0;
//        Predicate<Integer> predicate2 = item -> item % 2 != 0;
//
//        System.out.println(fillterList(numbers, predicate));
//        System.out.println(fillterList(numbers, predicate1));
//        System.out.println(fillterList(numbers, predicate2));

        PredicateDemo<Integer> predicateDemo = new PredicateDemo<>();

    }

    public  List<T> fillterList(List<T> list, Predicate<T> predicate) {
        List<T> rs = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                rs.add(item);
            }
        }
        return rs;
    }
}
