import java.util.*;

public class DiceCombination {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            long dp[] = new long[n + 1];
            dp[0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int face = 1; face <= 6; face++) {
                    if (i - face >= 0)
                        dp[i] = (dp[i] + dp[i - face]) % MOD;
                }
            }
            System.out.println(dp[n]);
        }
    }
}
