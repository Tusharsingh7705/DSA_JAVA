import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TreeDistannce {
    static int n;
    static List<Integer>[] adj;
    static int[] size, parent;
    static long[] dp, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        List<Integer>[] tmp = new ArrayList[n + 1];
        adj = tmp;
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        size = new int[n + 1];
        dp = new long[n + 1];
        ans = new long[n + 1];
        parent = new int[n + 1];

        int[] stack = new int[n];
        int top = 0;
        stack[top++] = 1;
        parent[1] = 0;

        int[] order = new int[n];
        int idx = 0;

        while (top > 0) {
            int node = stack[--top];
            order[idx++] = node;
            for (int nei : adj[node]) {
                if (nei == parent[node])
                    continue;
                parent[nei] = node;
                stack[top++] = nei;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int node = order[i];
            size[node] = 1;
            dp[node] = 0;

            for (int nei : adj[node]) {
                if (nei == parent[node])
                    continue;
                size[node] += size[nei];
                dp[node] += dp[nei] + size[nei];
            }
        }

        ans[1] = dp[1];

        stack = new int[n];
        top = 0;
        stack[top++] = 1;

        while (top > 0) {
            int node = stack[--top];

            for (int nei : adj[node]) {
                if (nei == parent[node])
                    continue;

                ans[nei] = ans[node] + (n - 2L * size[nei]);
                stack[top++] = nei;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(' ');
        }
        System.out.println(sb);
    }
}