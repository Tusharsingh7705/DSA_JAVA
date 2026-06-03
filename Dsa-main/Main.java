import java.io.*;
import java.util.*;

public class Main {

    static class DSU {
        int[] parent, size, min, max;

        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            min = new int[n + 1];
            max = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
                min[i] = i;
                max[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb)
                return;

            if (size[pa] < size[pb]) {
                parent[pa] = pb;
                size[pb] += size[pa];
                min[pb] = Math.min(min[pb], min[pa]);
                max[pb] = Math.max(max[pb], max[pa]);
            } else {
                parent[pb] = pa;
                size[pa] += size[pb];
                min[pa] = Math.min(min[pa], min[pb]);
                max[pa] = Math.max(max[pa], max[pb]);
            }
        }

        String get(int v) {
            int root = find(v);
            return min[root] + " " + max[root] + " " + size[root];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        DSU dsu = new DSU(n);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();

            if (type.equals("union")) {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                dsu.union(u, v);
            } else {
                int v = Integer.parseInt(st.nextToken());
                sb.append(dsu.get(v)).append("\n");
            }
        }

        System.out.print(sb);
    }
}