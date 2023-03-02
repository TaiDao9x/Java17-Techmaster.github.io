package day13_graph.home;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 1, 1},
                {0, 1, 0, 1, 0, 0, 1},
                {0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0},
        };
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> daDuyet = new HashSet<>();

        // Add the first element
//        queue.add(0);
//        daDuyet.add(0);
//
//        // Mark daDuyet first element
//        while (!queue.isEmpty()) {
//            int u = queue.poll();
//            System.out.print(u + ", ");
//            for (int v = 0; v < graph.length; v++) {
//                if (graph[u][v] == 1 && !daDuyet.contains(v)) {
//                    queue.add(v);
//                    daDuyet.add(v);
//                }
//            }
//        }
//        System.out.println();
        daDuyet.add(0);
        BFS(0, graph, daDuyet);
    }

    public static void BFS(int u, int[][] graph, Set<Integer> daDuyet) {
        // process u
        System.out.print(u + " ");
        for (int i = 0; i < graph.length; i++) {
            if (graph[u][i] == 1 && !daDuyet.contains(i)) {
                daDuyet.add(i);
                BFS(i, graph, daDuyet);
            }
        }
    }
}
