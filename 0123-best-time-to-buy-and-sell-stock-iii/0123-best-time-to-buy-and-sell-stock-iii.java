class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][3];
        return solve(0, 1, 2, prices, dp);
    }

    public int solve(int idx, int canBuy, int cap, int[] prices, Integer[][][] dp) {
        if (idx == prices.length || cap == 0) return 0;
        if (dp[idx][canBuy][cap] != null) return dp[idx][canBuy][cap];

        if (canBuy == 1) {
            int buy = -prices[idx] + solve(idx + 1, 0, cap, prices, dp);
            int skip = solve(idx + 1, 1, cap, prices, dp);
            return dp[idx][canBuy][cap] = Math.max(buy, skip);
        } else {
            int sell = prices[idx] + solve(idx + 1, 1, cap - 1, prices, dp);
            int skip = solve(idx + 1, 0, cap, prices, dp);
            return dp[idx][canBuy][cap] = Math.max(sell, skip);
        }
    }
}
