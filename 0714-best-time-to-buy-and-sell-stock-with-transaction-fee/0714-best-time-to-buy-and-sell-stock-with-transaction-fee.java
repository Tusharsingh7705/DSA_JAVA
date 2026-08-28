import java.util.*;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }

        return solve(0, 1, prices, fee, dp);
    }

    private int solve(int i, int canBuy, int[] prices, int fee, int[][] dp) {
        if (i >= prices.length) return 0;

        if (dp[i][canBuy] != -1) {
            return dp[i][canBuy];
        }

        if (canBuy == 1) {
            int pick = -prices[i] + solve(i + 1, 0, prices, fee, dp);
            int notPick = solve(i + 1, 1, prices, fee, dp);
            return dp[i][canBuy] = Math.max(pick, notPick);
        } else {
            int pick = prices[i] - fee + solve(i + 1, 1, prices, fee, dp);
            int notPick = solve(i + 1, 0, prices, fee, dp);
            return dp[i][canBuy] = Math.max(pick, notPick);
        }
    }
}
