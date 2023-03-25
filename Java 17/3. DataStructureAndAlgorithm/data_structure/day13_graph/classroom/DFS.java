package day13_graph.classroom;

import java.util.*;

public class DFS {
    public static void main(String[] args) {
        int[][] graph = {
                //  0  1  2  3  4  5  6
                {0, 1, 0, 0, 0, 0, 0}, // 0
                {1, 0, 1, 1, 1, 0, 0}, // 1
                {0, 1, 0, 0, 0, 1, 0}, // 2
                {0, 1, 0, 0, 0, 1, 1}, // 3
                {0, 1, 0, 0, 0, 0, 1}, // 4
                {0, 0, 1, 1, 0, 0, 0}, // 5
                {0, 0, 0, 1, 1, 0, 0}  // 6
        };
        DFS_stack(graph);
        System.out.println();
        Set<Integer> visited = new HashSet<>();
        DFS_recursion(graph, visited, 0);
        System.out.println();
        BFS(graph);
    }

    private static void DFS_stack(int[][] graph) {
        Stack<Integer> stack = new Stack<>();
        // add dinh 0 vao stack
        stack.add(0);
        // danh dau 0 da duoc duyet
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        // duyet stack den khi stack rong
        while (!stack.isEmpty()) {
            // lay ra dinh o top
            int u = stack.pop();
            System.out.print(u + " ");
            // add cac dinh ke voi u vao stack va cho u vao visited
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] == 1 && !visited.contains(v)) {
                    stack.add(v);
                    visited.add(v);
                }
            }
        }
    }

    private static void DFS_recursion(int[][] graph, Set<Integer> visited, int u) {
        // process
        System.out.print(u + " ");
        visited.add(u);
        for (int v = graph.length - 1; v >= 0; v--) {
            if (graph[u][v] == 1 && !visited.contains(v)) {
                DFS_recursion(graph, visited, v);
            }
        }
    }

    private static void BFS(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        // add dinh 0 vao queue
        queue.add(0);
        // danh dau 0 da duoc duyet
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        // duyet stack den khi queue rong
        while (!queue.isEmpty()) {
            // lay ra dinh o top
            int u = queue.poll();
            System.out.print(u + " ");
            // add cac dinh ke voi u vao queue va cho u vao visited
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] == 1 && !visited.contains(v)) {
                    queue.add(v);
                    visited.add(v);
                }
            }
        }
    }

}
