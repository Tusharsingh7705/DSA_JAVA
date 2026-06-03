import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RoundTrip {

    static boolean found = false;

    public static ArrayList<Integer> cycle(int node, int parent, boolean vis[], boolean path[],
            ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans) {

        vis[node] = true;
        path[node] = true;
        ans.add(node);

        for (int it : adj.get(node)) {

            if (it == parent)
                continue;

            if (!vis[it]) {
                cycle(it, node, vis, path, adj, ans);
                if (found)
                    return ans;
            } else if (path[it]) {
                ans.add(it);
                found = true;
                return ans;
            }
        }

        path[node] = false;
        ans.remove(ans.size() - 1);
        return ans;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] vis = new boolean[n + 1];
        boolean[] path = new boolean[n + 1];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!vis[i] && !found) {
                cycle(i, -1, vis, path, adj, ans);
            }
        }

        if (!found) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        int last = ans.get(ans.size() - 1);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(last);

        for (int i = ans.size() - 2; i >= 0; i--) {
            res.add(ans.get(i));
            if (ans.get(i) == last)
                break;
        }

        System.out.println(res.size());
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}