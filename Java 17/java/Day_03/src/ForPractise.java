public class ForPractise {
    public static String repeateString(String str) {
        String rs = "";
        for (int i = 0; i <= 10; i++) {
            rs = rs + str;
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(repeateString("Tài"));
    }
}

