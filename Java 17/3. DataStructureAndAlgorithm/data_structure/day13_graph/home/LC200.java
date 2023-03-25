package day13_graph.home;

public class LC200 {
    boolean[][] daDuyet = new boolean[300][300];
    int soHang;
    int soCot;

    public boolean isValid(int i, int j) {
        return i >= 0 && j >= 0 && i < soHang && j < soCot;
    }

    public void DFS(int i, int j, char[][] a) {

        // B1: Dieu kien dung | bai toan co so
        if (!isValid(i, j)) return;
        if (a[i][j] == '0' || daDuyet[i][j]) return;

        // Danh dau da duyet
        daDuyet[i][j] = true;
        // De quy || cong thuc truy hoi
        DFS(i, j + 1, a);
        DFS(i, j - 1, a);
        DFS(i + 1, j, a);
        DFS(i - 1, j, a);


    }

    public int numIslands(char[][] a) {
        int count = 0;
        soHang = a.length;
        soCot = a[0].length;

        for (int i = 0; i < soHang; i++) {
            for (int j = 0; j < soCot; j++) {
                if (a[i][j] == '1' && !daDuyet[i][j]) {
                    DFS(i, j, a);
                    count++;
                }
            }
        }
        return count;
    }
}
