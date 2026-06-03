import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestRoutes {

    static class Pair {
        long first;
        int second;

        Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int src = 0;
        int dest = V - 1;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Pair(w, v));
            adj.get(v).add(new Pair(w, u));
        }

        long[] dist = new long[V];
        int[] parent = new int[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[src] = 0;
        parent[src] = src;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.first, b.first));
        pq.add(new Pair(0L, src));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            long w = p.first;
            int curr = p.second;

            if (w > dist[curr]) continue;

            for (Pair it : adj.get(curr)) {
                int next = it.second;
                long weight = it.first;

                if (w + weight < dist[next]) {
                    dist[next] = w + weight;
                    parent[next] = curr;
                    pq.add(new Pair(dist[next], next));
                }
            }
        }

        if (dist[dest] == Long.MAX_VALUE) {
            System.out.print(-1);
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int node = dest;
        while (node != parent[node]) {
            path.add(node + 1);
            node = parent[node];
        }
        path.add(1);

        StringBuilder sb = new StringBuilder();
        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }

        System.out.print(sb.toString());
    }
}
