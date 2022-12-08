import java.util.Arrays;
//        Viết phương thức truyền vào 1 chuỗi bất kỳ
//        Thực hiện:
//        Đếm số từ trong chuỗi
//        Đếm và in ra index của các ký tự o trong chuỗi

public class Bai02_Java {
    public static void main(String[] args) {

        System.out.println("Số từ trong chuỗi 1 là: " + countLetter("Đào Văn Tài Java 17"));

        countLetterO("Đào Văno Tàoi Jaova 17");
    }

    public static int countLetter(String text) {
        String arr[] = text.split(" ");
        return arr.length;
    }

    public static void countLetterO(String text) {
        int count = 0;
       
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'o') {
                count++;
            }
        }

        if (count > 0) {
            System.out.printf("Số ký tự o trong chuỗi 2 là: %d.\n", count);

            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == 'o') {
                    System.out.println("Chữ o ở vị trí: " + i);
                }
            }
        } else {
            System.out.println("Không có ký tự o nào trong chuỗi!");
        }


    }

}
