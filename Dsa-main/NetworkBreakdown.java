import java.io.*;
import java.util.*;

public class NetworkBreakdown {
    static class DSU {
        int[] parent, size;
        int components;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        void union(int a, int b) {
            int roota = find(a);
            int rootb = find(b);

            if (roota == rootb) {
                return;
            }

            if (size[roota] < size[rootb]) {
                int temp = roota;
                roota = rootb;
                rootb = temp;
            }

            parent[rootb] = roota;
            size[roota] += size[rootb];
            components--;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] edges = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken()) - 1;
            edges[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        HashSet<String> set = new HashSet<>();
        ArrayList<int[]> listRemoved = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            set.add(a + "#" + b);
            set.add(b + "#" + a);
            listRemoved.add(new int[] { a, b });
        }

        ArrayList<Integer> list = new ArrayList<>();

        DSU dsu = new DSU(n);

        for (int i = 0; i < m; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            if (!set.contains(u + "#" + v)) {
                if (dsu.find(u) != dsu.find(v)) {
                    dsu.union(u, v);
                }
            }
        }

        for (int i = listRemoved.size() - 1; i >= 0; i--) {

            list.add(dsu.components);

            int u = listRemoved.get(i)[0];
            int v = listRemoved.get(i)[1];

            dsu.union(u, v);
        }

        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

}
