class Solution {
    public int maxProfit(int[] prices) {
        return helper(prices, 0, Integer.MAX_VALUE, 0);
    }

    public int helper(int[] prices, int idx, int minPrice, int maxProfit) {
        if (idx == prices.length) return maxProfit;

        minPrice = Math.min(minPrice, prices[idx]);
        maxProfit = Math.max(maxProfit, prices[idx] - minPrice);

        return helper(prices, idx + 1, minPrice, maxProfit);
    }
}
