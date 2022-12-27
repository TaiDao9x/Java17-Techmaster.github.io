import org.example.Staff;

import java.util.*;

public class Lambda {
    public static void main(String[] args) {


    }

    public static int number(String x) {
        int number = 0;
        if (x.length() > 1) {
            String x1 = String.valueOf(x.charAt(0));
            ;
            String x2 = String.valueOf(x.charAt(1));

            number = (getNumber(x1) * getNumber(x1)) + getNumber(x2);
        } else {
            number = getNumber(x);
        }
        return number;
    }

    public int getNumber(String x) {
        return switch (x) {
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> 3;
            case "D" -> 4;
            case "E" -> 5;
            case "F" -> 6;
            case "G" -> 7;
            case "H" -> 8;
            case "I" -> 9;
            case "J" -> 10;
            case "K" -> 11;
            case "L" -> 12;
            case "M" -> 13;
            case "N" -> 14;
            case "O" -> 15;
            case "P" -> 16;
            case "Q" -> 17;
            case "R" -> 18;
            case "S" -> 19;
            case "T" -> 20;
            case "U" -> 21;
            case "V" -> 22;
            case "W" -> 23;
            case "X" -> 24;
            case "Y" -> 25;
            case "Z" -> 26;
            default -> 0;
        };
    }
}
