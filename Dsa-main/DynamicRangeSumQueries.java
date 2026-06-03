import java.io.*;
import java.util.*;

public class DynamicRangeSumQueries {

    static long[] seg;
    static long[] arr;

    static void build(int idx, int low, int high) {
        if (low == high) {
            seg[idx] = arr[low];
            return;
        }

        int mid = (low + high) / 2;

        build(2 * idx + 1, low, mid);
        build(2 * idx + 2, mid + 1, high);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    static void update(int idx, int low, int high, int pos, long val) {

        if (low == high) {
            seg[idx] = val;
            arr[pos] = val;
            return;
        }

        int mid = (low + high) / 2;

        if (pos <= mid)
            update(2 * idx + 1, low, mid, pos, val);
        else
            update(2 * idx + 2, mid + 1, high, pos, val);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    static long query(int idx, int low, int high, int l, int r) {

        if (r < low || high < l)
            return 0;

        if (l <= low && high <= r)
            return seg[idx];

        int mid = (low + high) / 2;

        return query(2 * idx + 1, low, mid, l, r)
                + query(2 * idx + 2, mid + 1, high, l, r);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new long[n];
        seg = new long[4 * n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(st.nextToken());

        build(0, 0, n - 1);

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {

            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {

                int k = Integer.parseInt(st.nextToken()) - 1;
                long u = Long.parseLong(st.nextToken());

                update(0, 0, n - 1, k, u);

            } else {

                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                sb.append(query(0, 0, n - 1, a, b)).append("\n");
            }
        }

        System.out.print(sb);
    }
}