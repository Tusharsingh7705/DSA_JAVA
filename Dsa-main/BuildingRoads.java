import java.io.*;
import java.util.*;

public class BuildingRoads {

    static void dfs(int u, boolean[] visited, List<List<Integer>> graph) {
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(v, visited, graph);
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        ArrayList<Integer> con = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                con.add(i);
                dfs(i, visited, graph);
            }
        }

        int k = con.size() - 1;
        StringBuilder sb = new StringBuilder();
        sb.append(k).append('\n');

        for (int i = 1; i < con.size(); i++) {
            int u = con.get(i - 1) + 1;
            int v = con.get(i) + 1;
            sb.append(u).append(" ").append(v).append('\n');
        }

        System.out.print(sb.toString());
    }
}
