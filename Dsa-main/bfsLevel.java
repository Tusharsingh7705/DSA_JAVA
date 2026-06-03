import java.util.*;

public class bfsLevel {

    static ArrayList<Integer> bfs(int start, ArrayList<ArrayList<Integer>> graph, int n) {
        boolean[] visited = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        visited[start] = true;
        q.add(new int[] { start, 0 });

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int level = curr[1];

            System.out.println("Node: " + node + " Level: " + level);
            list.add(node);

            for (int i : graph.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(new int[] { i, level + 1 });
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);
        graph.get(4).add(5);

        System.out.println("BFS Order: " + bfs(0, graph, n));
    }

}
