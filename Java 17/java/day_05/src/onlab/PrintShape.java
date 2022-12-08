package onlab;

public class PrintShape {
    public static void main(String[] args) {
        printRectangle(4, 4);
    }

    public static void printRectangle(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


}
