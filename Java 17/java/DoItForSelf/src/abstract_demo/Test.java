package abstract_demo;

import java.text.NumberFormat;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        Toado td1 = new Toado(5, 5);
        Toado td2 = new Toado(7, 9);
        Toado td3 = new Toado(12, 1);

//        Hinh hinh =new Hinh(td1);

        Hinh h1 = new Diem(td1);

        Hinh h2 = new HinhTron(td2, 10);

        Hinh h3 = new HinhChuNhat(td3, 5, 6);

        int numer = 100000;

        formattingNumber(numer);
    }

    public static void formattingNumber(int number) {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);
        System.out.println(vn.format(number));

    }
}
