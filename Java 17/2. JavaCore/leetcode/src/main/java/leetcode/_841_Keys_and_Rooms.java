package leetcode;

import java.util.*;

public class _841_Keys_and_Rooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> roomKeys1 = new ArrayList<>();
        roomKeys1.add(1);
        rooms.add(roomKeys1);

        List<Integer> roomKeys2 = new ArrayList<>();
        roomKeys2.add(2);
        rooms.add(roomKeys2);

        List<Integer> roomKeys3 = new ArrayList<>();
        roomKeys3.add(3);
        rooms.add(roomKeys3);

        List<Integer> roomKeys4 = new ArrayList<>();
        rooms.add(roomKeys4);

        System.out.println(canVisitAllRooms3(rooms));
    }

    // DFS
    public static boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[rooms.size()];

        visited[0] = true;
        stack.add(0);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int key : rooms.get(u)) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.add(key);

                }
            }
        }

        for (Boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }


    // BFS
    public static boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        for (int r : rooms.get(0)) {
            visited.add(r);
            queue.add(r);
        }

        while (!queue.isEmpty()) {
            int r = queue.poll();
            visited.add(r);

            for (int c : rooms.get(r)) {
                if (!visited.contains(c)) {
                    queue.add(c);
                }
            }
        }
        return visited.size() == rooms.size();
    }


    // Recursion
    public static boolean canVisitAllRooms3(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        DFS(0, rooms, visited);
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private static void DFS(int i, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int c : rooms.get(i)) {
            DFS(c, rooms, visited);
        }
    }
}
