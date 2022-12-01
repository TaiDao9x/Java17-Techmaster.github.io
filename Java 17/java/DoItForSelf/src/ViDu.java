

public class ViDu {

    public static String minCat(String text1, String text2) {
        String text;
        int diff;

        if (text1.length() == text2.length()) {
            text = text1 + text2;
        }
        if (text1.length() > text2.length()) {
            diff = text1.length() - text2.length();
            text = text1.substring(diff) + text2;
        } else {
            diff = text2.length() - text1.length();
            text = text1 + text2.substring(diff);
        }

        return text;
    }

    public static void main(String[] args) {

        String st1 = "Welcome";
        String st2 = "home";

        System.out.println("Hai chuỗi là: " + st1 + " và " + st2);
        System.out.println("Chuỗi mới là: " + minCat(st1, st2));

    }
}