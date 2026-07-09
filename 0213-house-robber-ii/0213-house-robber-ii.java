class Solution {

    int n;
    int[] dp;

    public int helper(int[] nums, int i) {
        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        int steal = nums[i] + helper(nums, i + 2);
        int skip = helper(nums, i + 1);

        return dp[i] = Math.max(steal, skip);
    }

    public int rob(int[] nums) {

        if (nums.length == 1) return nums[0];        
        n = nums.length - 1;
        dp = new int[n];
        Arrays.fill(dp, -1);
        int case1 = helper(nums, 0);

        
        n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        int case2 = helper(nums, 1);

        return Math.max(case1, case2);
    }
}
