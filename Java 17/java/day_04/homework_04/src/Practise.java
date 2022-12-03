import java.util.Scanner;

public class Practise {
    public static void main(String[] args) {
        //khai báo một chuỗi str với nội dùng nhất định
        String str = "Chào mừng các bạn đến với Freetuts.net";

        // tạo một mảng char result để lưu trữ sau khi chuyển đổi
        char[] result;
        //sử dụng phương thức toCharArray() để chuyển đổi str sau đó gán cho result
        result = str.toCharArray();
        //sau khi chuyển đổi thì in ra màn hình
        System.out.println("Chuỗi sau khi đã chuyển đổi kiểu dữ liệu: ");
        System.out.println(result);


    }
}


