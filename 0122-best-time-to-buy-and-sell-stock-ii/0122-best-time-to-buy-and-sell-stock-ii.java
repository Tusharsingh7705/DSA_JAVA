class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];
        return solve(0, 1, prices, dp);
    }

    public int solve(int idx, int canBuy, int[] prices, Integer[][] dp) {
        if (idx == prices.length) return 0;
        if (dp[idx][canBuy] != null) return dp[idx][canBuy];

        if (canBuy == 1) {
            int pick = -prices[idx] + solve(idx + 1, 0, prices, dp);
            int notPick = solve(idx + 1, 1, prices, dp);
            return dp[idx][canBuy] = Math.max(pick, notPick);
        } else {
            int pick = prices[idx] + solve(idx + 1, 1, prices, dp);
            int notPick = solve(idx + 1, 0, prices, dp);
            return dp[idx][canBuy] = Math.max(pick, notPick);
        }
    }
}
