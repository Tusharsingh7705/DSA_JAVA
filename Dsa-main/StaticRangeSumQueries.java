import java.io.*;
import java.util.*;

public class StaticRangeSumQueries {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[] prefix = new long[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + Long.parseLong(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(prefix[b] - prefix[a - 1]).append("\n");
        }

        System.out.print(sb);
    }
}