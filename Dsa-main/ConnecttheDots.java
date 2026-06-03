import java.util.*;

public class ConnecttheDots {
    static class DSU {

        int[] parent, size;
        int components;

        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            components = n;

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);

            if (pa == pb)
                return;

            if (size[pa] < size[pb]) {
                parent[pa] = pb;
                size[pb] += size[pa];
            } else {
                parent[pb] = pa;
                size[pa] += size[pb];
            }

            components--;
        }
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();

            while (t-- > 0) {

                int n = sc.nextInt(), m = sc.nextInt();
                DSU dsu = new DSU(n);

                for (int idx = 0; idx < m; idx++) {

                    int d = sc.nextInt();
                    sc.nextInt(); // read unused value
                    sc.nextInt(); // read unused value

                    int[][] pc = new int[d + 1][n + 1];

                    for (int i = 0; i <= n; i++) {
                        for (int j = 0; j < 10; j++) {
                            if (pc[d][i] != 0) {
                                if (i + d <= n) {
                                    pc[d][i + d] = Math.min(pc[d][i + d], pc[d][i] + 1);
                                    dsu.union(i, i + d);
                                }
                            }
                        }
                    }
                }

                System.out.println(dsu.components);
            }
        }
    }
}