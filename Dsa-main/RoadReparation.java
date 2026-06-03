import java.io.*;
import java.util.*;

public class RoadReparation {
    static class DSU {
        int parent[];
        int size[];
        int components;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            this.components = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int u) {
            if (parent[u] == u)
                return u;
            return parent[u] = find(parent[u]);
        }

        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu == pv)
                return false;
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
            components--;
            return true;
        }

        static class edge {
            int u, v;
            long w;

            public edge(int u, int v, long w) {
                this.u = u;
                this.v = v;
                this.w = w;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        DSU.edge[] edges = new DSU.edge[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            long w = Long.parseLong(st.nextToken());
            edges[i] = new DSU.edge(u, v, w);
        }

        Arrays.sort(edges, (a, b) -> Long.compare(a.w, b.w));

        DSU dsu = new DSU(n);
        long cost = 0;

        for (DSU.edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                cost += e.w;
            }
        }

        if (dsu.components > 1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(cost);
        }
    }
}