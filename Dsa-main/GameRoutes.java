import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GameRoutes {
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
                inDegree[it]--;
                if (inDegree[it] == 0)
                    q.offer(it);
            }
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;

        for (int it : topo) {
            for (int next : adj.get(it)) {
                dp[next] = (dp[next] + dp[it]) % 1000000007;
            }
        }
        System.out.println(dp[n]);

    }

}
