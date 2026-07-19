class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, arr, k, dp);
    }

    private int solve(int index, int[] arr, int k, int[] dp) {
        if (index == arr.length) return 0;
        if (dp[index] != -1) return dp[index];

        int max = 0;
        int ans = 0;

        for (int i = 1; i <= k && index + i <= arr.length; i++) {
            max = Math.max(max, arr[index + i - 1]);
            ans = Math.max(ans, max * i + solve(index + i, arr, k, dp));
        }

        return dp[index] = ans;
    }
}
