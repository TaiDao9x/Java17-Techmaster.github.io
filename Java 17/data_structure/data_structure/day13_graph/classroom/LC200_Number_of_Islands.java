package day13_graph.classroom;

import java.util.LinkedList;
import java.util.Queue;

public class LC200_Number_of_Islands {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // duyet
                    // DFS
                    count++;

                    BFS(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private boolean isNotValid(char[][] grid, boolean[][] visited, int x, int y) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length

                || visited[x][y] || grid[x][y] == '0';

    }

    private void BFS(char[][] grid, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int currX = point[0];
            int currY = point[1];

            // tao ra bon diem
            for (int i = 0; i < direction.length; i++) {
                int newX = direction[i][0] + currX;
                int newY = direction[i][1] + currY;
                if (isNotValid(grid, visited, newX, newY)) {
                    continue;
                }
                queue.add(new int[]{newX, newY});
                visited[newX][newY] = true;
            }
        }
    }

    private void DFS(char[][] grid, boolean[][] visited, int x, int y) {
        if (isNotValid(grid, visited, x, y)) {
            return;
        }
        // process
        visited[x][y] = true;

        // lan luot xet 4 dinh xung quanh dinh hien tai, dua tren x va y
        DFS(grid, visited, x - 1, y);
        DFS(grid, visited, x + 1, y);
        DFS(grid, visited, x, y - 1);
        DFS(grid, visited, x, y + 1);
    }
}
