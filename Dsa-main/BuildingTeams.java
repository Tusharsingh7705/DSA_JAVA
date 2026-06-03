import java.io.*;
import java.util.*;

class BuildingTeams {

    public static boolean dfs(int node, int col, int color[], ArrayList<ArrayList<Integer>> adj) {
        color[node] = col;

        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (!dfs(it, 1 - color[node], color, adj)) {
                    return false;
                }
            } else if (color[it] == color[node]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, adj)) {
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(color[i] + 1).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}