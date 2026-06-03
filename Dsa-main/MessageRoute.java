import java.io.*;
import java.util.*;

class MessageRoute {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int m = fs.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        parent[1] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if (parent[v] == -1) {
                    parent[v] = u;
                    q.add(v);
                }
            }
        }

        if (parent[n] == -1) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        List<Integer> path = new ArrayList<>();
        for (int cur = n; cur != 0; cur = parent[cur]) {
            path.add(cur);
        }
        Collections.reverse(path);

        System.out.println(path.size());
        for (int x : path) {
            System.out.print(x + " ");
        }
    }

    static class FastScanner {
        byte[] buf = new byte[1 << 16];
        int idx = 0, size = 0;
        InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int read() throws IOException {
            if (idx >= size) {
                size = in.read(buf);
                idx = 0;
                if (size <= 0)
                    return -1;
            }
            return buf[idx++];
        }

        int nextInt() throws IOException {
            int c, sgn = 1, res = 0;
            do {
                c = read();
            } while (c <= ' ');
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res * sgn;
        }
    }
}
