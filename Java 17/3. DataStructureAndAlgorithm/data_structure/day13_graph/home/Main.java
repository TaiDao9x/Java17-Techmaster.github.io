package day13_graph.home;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {
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
//        DFS(graph);
        Set<Integer> visited = new HashSet<>();
        DFS(graph, visited, 0);

    }

    private static void DFS(int[][] graph, Set<Integer> visited, int u) {

        System.out.print(u + " ");
        visited.add(u);
        for (int v = graph.length - 1; v >= 0; v--) {
            if (graph[u][v] != 0 && !visited.contains(v)) {
                DFS(graph, visited, v);
            }
        }
    }
}
