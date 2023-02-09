package day04;

public class Homework {

    // duyệt mảng 2 chiều bằng đệ quy


    private static void Duyet(int i, int j, int[][] arr) {
        if (i == arr.length) {
            return;
        }

        System.out.print(arr[i][j]+" ");
        if (j < arr[i].length - 1) {
            Duyet(i, j + 1, arr);
            return;
        }
        System.out.println();
        Duyet(i + 1, 0, arr);

    }

    public static void main(String[] args) {

        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };

        Duyet(0, 0, a);
    }
}
