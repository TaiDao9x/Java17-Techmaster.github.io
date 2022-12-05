import java.util.Arrays;
import java.util.Random;

public class arrayPractise {
    public static void main(String[] args) {

//        int[] arr = {4, 2, 5, 6, 2, 7};
//
//        getSurplus(arr);
//
        repeatText2("a");

//        int[] arr = {1, 2, 3, 4, 5};
//        if (checkElementExist(arr, 10)) {
//            System.out.println("%d có nằm trong mảng");
//        } else {
//            System.out.println("%d không nằm trong mảng");
//        }

//        System.out.println("randomHexCode là: #" + randomHexCode());

//        System.out.printf("rgb(%s)", randomRgbCode());


    }


    public static String randomRgbCode() {
        Random rand = new Random();
        int rgb[] = new int[3];
        String phay = ",";
        String result1 = "";
        for (int i = 0; i < 3; i++) {
            int randomRgb = rand.nextInt(256);
            rgb[i] = randomRgb;
            String result = String.valueOf(rgb[i]);
            if (i == 2) {
                result1 = result1 + result;
            } else {
                result1 = result1 + result + phay;
            }
        }
        return result1;
    }

    public static String randomHexCode() {
        Random rand = new Random();
        char hex1 = ' ';

        char randomHex[] = new char[6];
        for (int i = 0; i < 6; i++) {
            int hex = rand.nextInt(16);
            switch (hex) {
                case 1: {
                    hex1 = '1';
                    break;
                }
                case 2: {
                    hex1 = '2';
                    break;
                }
                case 3: {
                    hex1 = '3';
                    break;
                }
                case 4: {
                    hex1 = '4';
                    break;
                }
                case 5: {
                    hex1 = '5';
                    break;
                }
                case 6: {
                    hex1 = '6';
                    break;
                }
                case 7: {
                    hex1 = '7';
                    break;
                }
                case 8: {
                    hex1 = '8';
                    break;
                }
                case 9: {
                    hex1 = '9';
                    break;
                }
                case 10: {
                    hex1 = 'a';
                    break;
                }
                case 11: {
                    hex1 = 'b';
                    break;
                }
                case 12: {
                    hex1 = 'c';
                    break;
                }
                case 13: {
                    hex1 = 'd';
                    break;
                }
                case 14: {
                    hex1 = 'e';
                    break;
                }
                case 15: {
                    hex1 = 'f';
                    break;
                }
            }
            randomHex[i] = hex1;

        }
        return String.valueOf(randomHex);
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

            arr[i] = text+"-";
            System.out.print(arr[i]);
        }

    }

}
