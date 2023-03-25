package exception_demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowAndThrowsDemo {
    public static void main(String[] args) {

        try {
            getAge(17);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            getFile();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }

    public static void getAge(int age) {
        if (age >= 18) {
            System.out.println("Đủ tuổi đi nghĩa vụ.");
        } else {
            throw new ArithmeticException("Không đủ tuổi");
        }
    }

    public static void getFile() throws FileNotFoundException {
        File file = new File("html.txt");

        FileReader fileReader = new FileReader(file);
        System.out.println("ĐỌc xong file");
    }

}

