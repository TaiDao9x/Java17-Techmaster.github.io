package wraperclassdemo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        int a = 5;
//        double b = 5.65;
//
//        // Chuyển đổi thành wrapper objects tương ứng
//        Integer aObj = Integer.valueOf(a);
//        Double bObj = Double.valueOf(b);
//
//        if (aObj instanceof Integer) {
//            System.out.println("Một object thuộc Integer đã được tạo.");
//        }
//
//        if (bObj instanceof Double) {
//            System.out.println("Một object thuộc Double đã được tạo.");
//        }


        // Tạo object thuộc wrapper class
//        Integer aObj = Integer.valueOf(23);
//        Double bObj = Double.valueOf(5.55);
//
//        // Chuyển đổi thành kiểu dữ liệu nguyên thủy tương ứng
//        int a = aObj.intValue();
//        double b = bObj.doubleValue();
//
//        System.out.println("Giá trị a = " + a);
//        System.out.println("Giá trị b = " + b);

        ArrayList<Integer> list = new ArrayList<>();

        //autoboxing
        list.add(5);
        list.add(6);

        System.out.println("ArrayList: " + list);

        // unboxing
        Integer a = list.get(0);
        System.out.println("Value at index 0: " + a);
    }
}


