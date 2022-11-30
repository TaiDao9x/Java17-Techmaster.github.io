public class IfDemo {
    public static void main(String[] args) {
        // Ví dụ
        // && || !
        int hour = 19;
        if (hour < 12) {
            System.out.println("Good morning!");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Good afternoon");
        } else {
            System.out.println("Good evening");
        }

        boolean troiDep = true;
        boolean coTien = true;
        if (troiDep && coTien) {
            System.out.println("Đi chơi");
        } else {
            System.out.println("Ở nhà");
        }

        if (troiDep || coTien) {
            System.out.println("Đi chơi 2");
        }

        // Toán tử 3 ngôi
        String message = (!troiDep && coTien) ? "Đi chơi" : "Ở nhà";
        System.out.println(message);

        int number = 12;
        String text = number > 0 ? "Số dương" : number == 0 ? "Số 0" : "Số âm";
        System.out.println(text);
    }
}
