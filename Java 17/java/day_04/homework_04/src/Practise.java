import java.util.Scanner;

public class Practise {
    public static void main(String[] args) {
//        //khai báo một chuỗi str với nội dùng nhất định
//        String str = "Chào mừng các bạn đến với Freetuts.net";
//
//        // tạo một mảng char result để lưu trữ sau khi chuyển đổi
//        char[] result;
//        //sử dụng phương thức toCharArray() để chuyển đổi str sau đó gán cho result
//        result = str.toCharArray();
//        //sau khi chuyển đổi thì in ra màn hình
//        System.out.println("Chuỗi sau khi đã chuyển đổi kiểu dữ liệu: ");
//        System.out.println(result);


//        Bài 1: Viết phương thức truyền vào 1 chuỗi bất kỳ và kiểm tra
//        xem chuỗi đó có là chuỗi đối xứng hay không?
//        Kết quả trả về là true hoặc false
//        (không phân biệt hoa thường, không tính khoảng trắng)
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhập vào chuỗi: ");
//        String text = sc.nextLine().toLowerCase();
//
//        String text1 = text.replaceAll(" ", "");
//        String text2 = "";
//
//        for (int i = text1.length() - 1; i >= 0; i--) {
//            text2 += text1.charAt(i);
//        }
//        System.out.println(text2);
//        System.out.println(text1.equals(text2));

//        Bài 2: Viết phương thức truyền vào 2 số nguyên bất kỳ,
//        tính tổng tất cả các số nguyên nằm giữa chúng.
//        Ví dụ với tham số 3 và 8 ta có kết quả là 22 (bằng 4 + 5 + 6 + 7)
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Truyền vào số 1: ");
//        int so1 = sc.nextInt();
//        System.out.print("Truyền vào số 2: ");
//        int so2 = sc.nextInt();
//        int sum = 0;
//
//        if (so1 > so2) {
//            for (int i = so2 + 1; i < so1; i++) {
//                sum += i;
//            }
//        } else {
//            for (int i = so1 + 1; i < so2; i++) {
//                sum += i;
//            }
//        }
//        System.out.printf("sum(%d,%d) = %d", so1, so2, sum);


//        Bài 3: Viết method truyền vào 1 số nguyên bất kỳ.
//        Kiểm tra xem số đó có phải là số nguyên tố hay không?
//        Kết quả trả về true hoặc false.

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số: ");
        int n = sc.nextInt();
        int sum = 2;
        if (n <= 1) {
            sum = 0;
            System.out.println("Nhập số không đúng!");
        } else if (n == 2) {
            sum = 2;
        } else {
            for (int i = 3; i <= n; i++) {
                if (isPrime(i)) {
                    sum += i;
                }
            }
        }
        System.out.printf("Tổng các số nguyên tố nhỏ hơn tới %d = %d", n, sum);
    }

    public static boolean isPrime(int number) {
        boolean check = true;
//        if (number <= 1) {
//            return false;
//        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                check = false;
                break;
            }
        }
        return check;
    }

    public static int sumDream(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

}
