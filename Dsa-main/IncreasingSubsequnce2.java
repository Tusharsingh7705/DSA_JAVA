import java.io.*;
import java.util.*;

public class IncreasingSubsequnce2 {

    static int MOD = 1000000007;
    static long[] tree;

    static void update(int node, int start, int end, int pos, long val) {
        if (start == end) {
            tree[node] = (tree[node] + val) % MOD;
            return;
        }

        int mid = (start + end) / 2;

        if (pos <= mid) {
            update(node * 2, start, mid, pos, val);
        } else {
            update(node * 2 + 1, mid + 1, end, pos, val);
        }

        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
    }

    static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left)
            return 0;

        if (left <= start && end <= right)
            return tree[node];

        int mid = (start + end) / 2;

        long lsum = query(node * 2, start, mid, left, right);
        long rsum = query(node * 2 + 1, mid + 1, end, left, right);

        return (lsum + rsum) % MOD;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] temp = arr.clone();
        Arrays.sort(temp);

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 1;

        for (int x : temp) {
            if (!map.containsKey(x)) {
                map.put(x, idx++);
            }
        }

        int size = idx;
        tree = new long[4 * size];

        long ans = 0;

        for (int i = 0; i < n; i++) {

            int val = map.get(arr[i]);

            long sum = query(1, 1, size, 1, val - 1);

            long dp = (sum + 1) % MOD;

            update(1, 1, size, val, dp);

            ans = (ans + dp) % MOD;
        }

        System.out.println(ans);
    }
}