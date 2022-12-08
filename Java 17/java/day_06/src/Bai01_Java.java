public class Bai01_Java {
    public static void main(String[] args) {
        sprintSquare();
        System.out.println();
        sprintTriangle();
    }

    public static void sprintSquare() {
        int size = 4;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void sprintTriangle() {
        int size = 4;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
