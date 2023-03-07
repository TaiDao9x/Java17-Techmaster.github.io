package day13_graph.classroom;

import java.util.*;

public class BFS {
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
        DFS(graph);
        System.out.println();
        BFS(graph);
        System.out.println();
        DFSRe(graph);
    }

    private static void DFS(int[][] graph) {
        // B1: add node 0 into stack and mark node was duyet
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.add(0);
        visited.add(0);
        // B2: find dinh ke in node dang xet va add into stack and visited
        // check stack ultil stack is empty
        while (!stack.isEmpty()) {
            // get the first ele of stack
            int u = stack.pop();
            System.out.print(u + " ");
            // find all node next to current node and wasn't duyet
            for (int v =  graph.length-1; v >=0; v--) {
                if (graph[u][v] != 0 && !visited.contains(v)) {
                    stack.add(v);
                    visited.add(v);
                }
            }
        }
    }

    private static void DFSRe(int[][] graph) {
        Set<Integer> visited = new HashSet<>();
        Recursion(graph, visited, 0);
    }

    private static void Recursion(int[][] graph, Set<Integer> visited, int u) {
        visited.add(u);
        System.out.print(u + " ");
        for (int v = 0; v < graph.length; v++) {
            if (graph[u][v] != 0 && !visited.contains(v)) {
                Recursion(graph, visited, v);
            }
        }
    }

    private static void BFS(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] != 0 && !visited.contains(v)) {
                    queue.add(v);
                    visited.add(v);
                }
            }
        }
    }
}
