package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _1926NearestExitFrom {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
//        boolean[][] visited = new boolean[maze.length][maze[0].length];

        queue.add(new int[]{entrance[0], entrance[1], 0});
//        visited[entrance[0]][entrance[1]] = true;
        maze[entrance[0]][entrance[1]] = '#';
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currStep = curr[2];

            for (int[] dir : dirs) {
                int x = currX + dir[0];
                int y = currY + dir[1];
                int step = currStep + 1;

                if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length
                        || maze[x][y] == '+'
                        || maze[x][y] == '#') {
                    continue;
                }
                if (x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1) {
                    return step;
                }
                queue.add(new int[]{x, y, step});
                maze[x][y] = '#';
            }
        }
        return -1;
    }
}
