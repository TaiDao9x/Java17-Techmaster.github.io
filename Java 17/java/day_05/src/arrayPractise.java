import java.util.Arrays;

public class arrayPractise {
    public static void main(String[] args) {

//        int[] arr = {4, 2, 5, 6, 2, 7};
//
//        getSurplus(arr);
//
//        repeatText2("a");

        int[] arr = {1, 2, 3, 4, 5};
        if (checkElementExist(arr, 10)) {
            System.out.println("%d có nằm trong mảng");
        } else {
            System.out.println("%d không nằm trong mảng");
        }

    }

    public static boolean checkElementExist(int[] arr, int number) {
        boolean checkeExist = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                checkeExist = true;
                break;
            }
        }
       return checkeExist;
    }

    public static void getSurplus(int[] arr) {

        int[] surplus = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            surplus[i] = arr[i] % 2;
        }
        System.out.println(Arrays.toString(surplus));
    }

    public static void repeatText(String text) {
        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = text;
            System.out.print(arr[i]);
        }

    }

    public static void repeatText2(String text) {
        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                arr[i] = text;
            } else {
                arr[i] = "-" + text;
            }
            System.out.print(arr[i]);
        }

    }

}
