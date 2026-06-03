import java.io.*;
import java.util.*;

public class Investigation {

    static class Edge {
        int v;
        long w;

        Edge(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }

    static class Node {
        int u;
        long d;

        Node(int u, long d) {
            this.u = u;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            adj.get(a).add(new Edge(b, c));
        }

        long[] dist = new long[n + 1];
        long[] ways = new long[n + 1];
        int[] minF = new int[n + 1];
        int[] maxF = new int[n + 1];

        Arrays.fill(dist, Long.MAX_VALUE);
        int MOD = 1000000007;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.d, b.d));

        dist[1] = 0;
        ways[1] = 1;
        minF[1] = 0;
        maxF[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.u;
            long d = cur.d;

            if (d > dist[u])
                continue;

            for (Edge e : adj.get(u)) {
                int v = e.v;
                long nd = d + e.w;

                if (nd < dist[v]) {
                    dist[v] = nd;
                    ways[v] = ways[u] % MOD;
                    minF[v] = minF[u] + 1;
                    maxF[v] = maxF[u] + 1;
                    pq.add(new Node(v, nd));
                } else if (nd == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                    minF[v] = Math.min(minF[v], minF[u] + 1);
                    maxF[v] = Math.max(maxF[v], maxF[u] + 1);
                }
            }
        }

        System.out.println(dist[n] + " " + ways[n] + " " + minF[n] + " " + maxF[n]);
    }
}
