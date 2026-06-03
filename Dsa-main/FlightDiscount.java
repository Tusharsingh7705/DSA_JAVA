import java.io.*;
import java.util.*;

public class FlightDiscount {
    static class Edge {
        int v;
        long w;

        Edge(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }

    static class Node {
        int u, used;
        long cost;

        Node(int u, long cost, int used) {
            this.u = u;
            this.cost = cost;
            this.used = used;
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

        long[][] dist = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dist[i][0] = Long.MAX_VALUE;
            dist[i][1] = Long.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        dist[1][0] = 0;
        pq.add(new Node(1, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.u;
            long cost = cur.cost;
            int used = cur.used;

            if (cost > dist[u][used])
                continue;

            for (Edge e : adj.get(u)) {
                int v = e.v;
                long w = e.w;

                if (dist[v][used] > cost + w) {
                    dist[v][used] = cost + w;
                    pq.add(new Node(v, dist[v][used], used));
                }

                if (used == 0) {
                    long newCost = cost + (w / 2);
                    if (dist[v][1] > newCost) {
                        dist[v][1] = newCost;
                        pq.add(new Node(v, newCost, 1));
                    }
                }
            }
        }

        System.out.println(Math.min(dist[n][0], dist[n][1]));
    }
}
