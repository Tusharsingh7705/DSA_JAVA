class Solution {
    int[][] dp;

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) arr[i + 1] = nums[i];

        dp = new int[n + 2][n + 2];
        for(int it[]:dp){
            Arrays.fill(it,-1);
        }

        return helper(arr, 1, n);
    }

    public int helper(int[] arr, int l, int r) {
        if (l > r) return 0;

        if (dp[l][r] != -1) return dp[l][r];

        int max = 0;

        for (int k = l; k <= r; k++) {
            int coins =
                helper(arr, l, k - 1) +
                arr[l - 1] * arr[k] * arr[r + 1] +
                helper(arr, k + 1, r);

            max = Math.max(max, coins);
        }

        return dp[l][r] = max;
    }
}
