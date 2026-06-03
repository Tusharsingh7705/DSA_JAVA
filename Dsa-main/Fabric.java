import java.util.*;

public class Fabric {

    static int n, m, h;
    static int[] A, B;
    static long[][][] dp;

    static long solve(int i, int j, int last) {
        if (i == n && j == m) return 0;
        if (dp[i][j][last] != -1) return dp[i][j][last];

        long max_beauty = 0;

        if (i < n) {
            int current_color = A[i];
            int bonus = 0;

            if (last == 1 && i > 0 && A[i - 1] == current_color) bonus = h;
            else if (last == 2 && j > 0 && B[j - 1] == current_color) bonus = h;

            max_beauty = Math.max(max_beauty, bonus + solve(i + 1, j, 1));
        }

        if (j < m) {
            int current_color = B[j];
            int bonus = 0;

            if (last == 1 && i > 0 && A[i - 1] == current_color) bonus = h;
            else if (last == 2 && j > 0 && B[j - 1] == current_color) bonus = h;

            max_beauty = Math.max(max_beauty, bonus + solve(i, j + 1, 2));
        }

        return dp[i][j][last] = max_beauty;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            m = sc.nextInt();
            h = sc.nextInt();

            A = new int[n];
            B = new int[m];

            for (int i = 0; i < n; i++) A[i] = sc.nextInt();
            for (int i = 0; i < m; i++) B[i] = sc.nextInt();

            dp = new long[n + 1][m + 1][3];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }

            System.out.println(solve(0, 0, 0));
        }
    }
}