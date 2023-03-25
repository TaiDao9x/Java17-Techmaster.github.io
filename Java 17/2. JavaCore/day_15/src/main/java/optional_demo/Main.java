package optional_demo;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();

        Optional<String> optional1 = Optional.of("Hello");

        Optional<String> optional2 = Optional.ofNullable(null);

// get(): trả về giá trị của optional
        // isEmpty: nếu bên trong optional không có giá trị ->true, ngược lại là false
        // isPresent: nếu bên trong
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("No value");
        }

        if (optional1.isPresent()) {
            System.out.println(optional1.get());
        } else {
            System.out.println("No value");
        }
//        System.out.println(optional.get());

        optional1.ifPresent(value -> System.out.println(value));

        //orElse: nếu bên trong optional không có giá trị nào sẽ được thay thế bằng 1 giá trị mặc đinh
        String message = optional.orElse("world");
        System.out.println(message);
        try {
            String message1 = optional.orElseThrow(() -> {
                throw new RuntimeException("có lỗi xảy ra");
            });

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
