import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoadConstruction {
    public static int max = 1;

    static class DSU {
        int size[];
        int parent[];
        int components;

        public DSU(int n) {
            size = new int[n + 1];
            parent = new int[n + 1];
            this.components = n;

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int u) {
            if (parent[u] == u)
                return u;
            return parent[u] = find(parent[u]);
        }

        public void union(int u, int v) {

            int pu = find(u);
            int pv = find(v);

            if (pu == pv) {

                System.out.println(components + " " + max);
                return;
            }

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
                max = Math.max(max, size[pv]);
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
                max = Math.max(max, size[pu]);
            }

            components--;

            System.out.println(components + " " + max);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        DSU obj = new DSU(n);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            obj.union(a, b);
        }
    }

}
