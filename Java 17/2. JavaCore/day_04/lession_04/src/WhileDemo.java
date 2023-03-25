public class WhileDemo {
    public static void main(String[] args) {
        // Thực hiện thức dậy lúc 5h trong 30 ngày
//        int day = 1;
//        while (day <= 30) {
//            System.out.printf("Ngày %d thức dậy lúc 5h\n", day);
//            day++;
//        }

        int day = 30;
        do {
            System.out.printf("Ngày %d thức dậy lúc 5h\n", day);
//            day++;
        } while (day <= 30);
    }
}
