package onlab;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
// Cách 1 : Khai báo sô lượng phần tử cho mảng
        int[] numbers = new int[3]; // Mảng có 3 phần tử

        // Khai báo giá trị cho các phần tử theo chỉ số
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        System.out.println(Arrays.toString(numbers));

        String text = Arrays.toString(numbers);
        System.out.println(text);
        String text2 = String.join(" ", text);
        System.out.println(text2);

        String[] names = {"Nguyễn Văn A", "Trần Văn B", "Ngô Thị C"};

        int i = 0;
        while (i < names.length) {
            System.out.println(names[i++]);
        }

        for (String name : names) {
            System.out.println("\n" + name);
        }

//        " một         ngày    nào     đó        "

        String a = "      một           ngày       nào đó        ";
//        String b = a.trim();
//        System.out.println(b);
        String c = a.replaceAll("\s+", " ");
        System.out.println(c);
    }
}
