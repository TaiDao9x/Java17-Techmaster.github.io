package learnbyself;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class arrayPractise {
    public static void main(String[] args) {

//        int[] arr = {4, 2, 5, 6, 2, 7};
//        System.out.println(getSurplus(arr));

//        System.out.println(repeatText("a"));

//        System.out.println(repeatText2("a"));

//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(checkElementExist(arr, 5));

//        System.out.println("randomHexCode là: #" + randomHexCode());

//        System.out.println(randomRgbCode());

//        System.out.println(500_000_000);
//        DecimalFormat formater = new DecimalFormat("#,###");
//        System.out.println(formater.format(200_000_000));

//        int arr[] = {3, 3};
//        randomHexCode2(arr, 6);

        System.out.println(randomHexCode2());

    }


    public static String randomRgbCode() {
        Random rand = new Random();
        int rgb[] = new int[3];

        for (int i = 0; i < 3; i++) {
            int randomRgb = rand.nextInt(256);
            rgb[i] = randomRgb;
        }
        String result = "rgb(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ")";
        return result;
    }

    public static void randomHexCode2(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            while (j < arr.length) {
                if (arr[i] + arr[j] == target) {
                    System.out.printf("[%d,%d]", i, j);
                    break;
                }
                j++;
            }
        }
    }

    public static String randomHexCode2() {
        String textToFind = "0123456789abcdef";
        Random random = new Random();
        char hex[] = new char[6];
        for (int i = 0; i < 6; i++) {
            int hexNumber = random.nextInt(16);
            hex[i] = textToFind.charAt(hexNumber);
        }
        String result = "#" + String.valueOf(hex);
        return result;
    }

    public static String randomHexCode() {
        Random rand = new Random();

        String hex[] = new String[6];
        for (int i = 0; i < 6; i++) {
            int hexCode = rand.nextInt(16);
            switch (hexCode) {
                case 10:
                    hex[i] = "a";
                    break;
                case 11:
                    hex[i] = "b";
                    break;
                case 12:
                    hex[i] = "c";
                    break;
                case 13:
                    hex[i] = "d";
                    break;
                case 14:
                    hex[i] = "e";
                    break;
                case 15:
                    hex[i] = "f";
                    break;
                default:
                    hex[i] = String.valueOf(hexCode);
                    break;
            }
        }
        String hex1 = String.join("", hex);
        return hex1;
    }

    public static boolean checkElementExist(int[] arr, int number) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
        return false;
    }

    public static String getSurplus(int[] arr) {
        int[] surplus = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            surplus[i] = arr[i] % 2;
        }
        String surplusString = Arrays.toString(surplus);
        return surplusString;
    }

    public static String repeatText(String text) {
        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = text;
        }
        String textString = String.join("", arr);
        return textString;
    }

    public static String repeatText2(String text) {
        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                arr[i] = text;
            } else {
                arr[i] = text + "-";
            }
        }
        String textString = String.join("", arr);
        return textString;
    }
}
