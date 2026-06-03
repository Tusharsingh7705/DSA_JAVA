import java.io.*;
import java.util.*;

public class TreeDistancesI {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;

            while ((c = read()) <= ' ')
                ;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }

            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner sc = new FastScanner();

        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] dis1 = new int[n];
        bfs(0, adj, dis1);

        int endA = 0;
        for (int i = 0; i < n; i++) {
            if (dis1[i] > dis1[endA]) {
                endA = i;
            }
        }

        int[] dis2 = new int[n];
        bfs(endA, adj, dis2);

        int endB = 0;
        for (int i = 0; i < n; i++) {
            if (dis2[i] > dis2[endB]) {
                endB = i;
            }
        }

        int[] dis3 = new int[n];
        bfs(endB, adj, dis3);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(Math.max(dis2[i], dis3[i])).append(" ");
        }

        System.out.println(sb);
    }

    public static void bfs(int start, ArrayList<ArrayList<Integer>> adj, int[] dis) {

        Arrays.fill(dis, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dis[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : adj.get(node)) {
                if (dis[next] == -1) {
                    dis[next] = dis[node] + 1;
                    q.add(next);
                }
            }
        }
    }
}