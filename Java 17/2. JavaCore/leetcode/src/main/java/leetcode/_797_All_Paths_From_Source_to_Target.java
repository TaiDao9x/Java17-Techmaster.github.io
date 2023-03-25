package leetcode;

import java.util.*;

public class _797_All_Paths_From_Source_to_Target {
    public List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
        List<List<Integer>> rs = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(0));

        while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            int lastNode = currentPath.get(currentPath.size() - 1);
            if (lastNode == graph.length - 1) {
                rs.add(currentPath);
            } else {
                for (int a : graph[lastNode]) {
                    List<Integer> newNextPath = new ArrayList<>(currentPath);
                    newNextPath.add(a);
                    queue.add(newNextPath);
                }
            }
        }
        return rs;
    }


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> rs = new ArrayList<>();
        int n = graph.length - 1;
        dfs(rs, graph, 0, n, new ArrayList<>());
        return rs;
    }

    private void dfs(List<List<Integer>> rs, int[][] graph, int i, int n, ArrayList<Integer> list) {
        list.add(i);
        if (i == n) {
            rs.add(new ArrayList<>(list));
        } else {
            for (int a : graph[i]) {
                dfs(rs, graph, a, n, list);
            }
        }
        list.remove(list.size() - 1);
    }
}
