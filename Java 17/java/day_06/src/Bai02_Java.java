import java.util.Arrays;
//        Viết phương thức truyền vào 1 chuỗi bất kỳ
//        Thực hiện:
//        Đếm số từ trong chuỗi
//        Đếm và in ra index của các ký tự o trong chuỗi

public class Bai02_Java {
    public static void main(String[] args) {
        String text = "Đào Văn Tài";
        System.out.printf("\nSố từ trong chuỗi \"%s\" là: %d\n", text, countLetter(text));

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

        int result[] = new int[count];
        int count1 = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'o') {
                result[count1] = i;
                count1++;
            }
        }

        if (count > 0) {
            System.out.printf("\nSố ký tự o trong chuỗi \"%s\" là: %d.\n", text, count);
            System.out.println("Chữ \"o\" ở các vị trí:" + Arrays.toString(result));
        } else {
            System.out.println("\nKhông có ký tự o nào trong chuỗi!");
        }
    }
}
