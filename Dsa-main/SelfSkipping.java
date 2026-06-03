import java.util.*;

public class SelfSkipping {

    static long solve(int[] arr, int idx, long[] dp) {
        int n = arr.length;
        if (idx >= n) return 0;
        if (dp[idx] != -1) return dp[idx];

        long notTake = solve(arr, idx + 1, dp);
        long take = arr[idx] + solve(arr, idx + arr[idx] + 1, dp);

        return dp[idx] = Math.max(take, notTake);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            long[] dp = new long[n + 1];
            Arrays.fill(dp, -1);

            System.out.println(solve(arr, 0, dp));
        }
    }
}