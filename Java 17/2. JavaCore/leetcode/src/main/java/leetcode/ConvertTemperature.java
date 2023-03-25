package leetcode;

import java.util.Arrays;

public class ConvertTemperature {
    public static void main(String[] args) {
        double celsius = 36.50;
        System.out.println(Arrays.toString(convertTemperature(celsius)));
    }

    public static double[] convertTemperature(double celsius) {
        double[] convertTemperature = new double[2];
        convertTemperature[0] = celsius + 273.15;
        convertTemperature[1] = celsius * 1.80 + 32.00;
        return convertTemperature;
    }
}
