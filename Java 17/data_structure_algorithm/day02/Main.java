public class Main {
    public static void main(String[] args) {
        String a="ghb";
        int[][] array2D = {
                {1, 2, 3, 100, 200},
                {4, 5, 6}
        };
        for (int[] ints : array2D) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }

        int[][] arr2 = new int[2][4];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = 1;
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.println();
            }
        }
    }
}
