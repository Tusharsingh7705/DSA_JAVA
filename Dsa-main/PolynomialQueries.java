import java.io.*;
import java.util.*;

public class PolynomialQueries {

    static int n, q;
    static long[] seg, lazyA, lazyD;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(st.nextToken());

        seg = new long[4 * n];
        lazyA = new long[4 * n];
        lazyD = new long[4 * n];

        build(0, 0, n - 1, arr);

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;

            if (type == 1) {
                update(0, 0, n - 1, l, r, 1);
            } else {
                sb.append(query(0, 0, n - 1, l, r)).append('\n');
            }
        }

        System.out.print(sb);
    }

    static void build(int idx, int l, int r, long[] arr) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2 * idx + 1, l, mid, arr);
        build(2 * idx + 2, mid + 1, r, arr);
        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    static void push(int idx, int l, int r) {
        if (lazyA[idx] == 0 && lazyD[idx] == 0)
            return;

        int len = r - l + 1;
        long a = lazyA[idx], d = lazyD[idx];

        seg[idx] += (len * (2 * a + (len - 1) * d)) / 2;

        if (l != r) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int mid = (l + r) / 2;

            lazyA[left] += a;
            lazyD[left] += d;

            lazyA[right] += a + (mid - l + 1) * d;
            lazyD[right] += d;
        }

        lazyA[idx] = 0;
        lazyD[idx] = 0;
    }

    static void update(int idx, int l, int r, int ql, int qr, long start) {
        push(idx, l, r);

        if (r < ql || l > qr)
            return;

        if (l >= ql && r <= qr) {
            lazyA[idx] += start + (l - ql);
            lazyD[idx] += 1;
            push(idx, l, r);
            return;
        }

        int mid = (l + r) / 2;
        update(2 * idx + 1, l, mid, ql, qr, start);
        update(2 * idx + 2, mid + 1, r, ql, qr, start);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    static long query(int idx, int l, int r, int ql, int qr) {
        push(idx, l, r);

        if (r < ql || l > qr)
            return 0;

        if (l >= ql && r <= qr)
            return seg[idx];

        int mid = (l + r) / 2;
        return query(2 * idx + 1, l, mid, ql, qr)
                + query(2 * idx + 2, mid + 1, r, ql, qr);
    }
}