package exception_demo;

public class UncheckExceptionDemo {
    public static void main(String[] args) {
//        int number = 9;
//        int zero = 0;
//        int result = number / zero;  //ArithmeticException

//        String str = null;
//        System.out.println(str.length()); //NullPointerException

//        String str = "Chuỗi";
//        int number = Integer.parseInt(str); //NumberFormatException

//        int []arr = new int[5];
//        arr[10] = 7; //ArrayIndexOutOfBoundsException

        int[] arr = new int[-5]; //NegativeArraySizeException

    }
}
