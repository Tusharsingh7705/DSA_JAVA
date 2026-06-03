import java.io.*;
import java.util.*;

public class LongestFlightRoute {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        int[] inDegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            inDegree[b]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            if (inDegree[i] == 0)
                q.offer(i);

        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int it : adj.get(node)) {
                if (--inDegree[it] == 0)
                    q.offer(it);
            }
        }

        int[] dp = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        dp[1] = 1;

        for (int it : topo) {
            if (dp[it] == 0)
                continue;
            for (int next : adj.get(it)) {
                if (dp[next] < dp[it] + 1) {
                    dp[next] = dp[it] + 1;
                    parent[next] = it;
                }
            }
        }

        if (dp[n] == 0) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        int cur = n;
        while (cur != -1) {
            ans.add(cur);
            cur = parent[cur];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n]).append("\n");
        for (int i = ans.size() - 1; i >= 0; i--)
            sb.append(ans.get(i)).append(" ");

        System.out.println(sb);
    }
}
