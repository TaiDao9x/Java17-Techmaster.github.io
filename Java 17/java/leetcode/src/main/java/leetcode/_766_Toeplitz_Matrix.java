package leetcode;

public class _766_Toeplitz_Matrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) { // Số bước toán là: n-1
            for (int j = 0; j < matrix[i].length - 1; j++) { // Số bước toán là: n-1
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}

// Độ phức tập thuật toán khi for nhau lồng nhau: (n-1)*(n-1)= n^2 - 2n +1 -> Độ phức tạp thuật toán: O(n^2)
