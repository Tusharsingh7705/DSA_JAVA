import java.io.*;
import java.util.*;

public class Hard {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] cost = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        String[] s = new String[n];
        String[] rev = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
            rev[i] = new StringBuilder(s[i]).reverse().toString();
        }

        long INF = (long) 4e18;

        long[][] dp = new long[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = INF;
            dp[i][1] = INF;
        }

        dp[0][0] = 0;
        dp[0][1] = cost[0];

        for (int i = 1; i < n; i++) {

            if (s[i - 1].compareTo(s[i]) <= 0) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
            }

            if (rev[i - 1].compareTo(s[i]) <= 0) {
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
            }

            if (s[i - 1].compareTo(rev[i]) <= 0) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + cost[i]);
            }

            if (rev[i - 1].compareTo(rev[i]) <= 0) {
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + cost[i]);
            }
        }

        long ans = Math.min(dp[n - 1][0], dp[n - 1][1]);

        System.out.println(ans >= INF ? -1 : ans);
    }
}