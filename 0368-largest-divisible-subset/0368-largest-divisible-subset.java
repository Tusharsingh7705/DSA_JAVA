class Solution {

    List<Integer>[][] dp;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        dp = new ArrayList[n][n + 1];

        return helper(nums, 0, -1);
    }

    private List<Integer> helper(int[] nums, int i, int prev) {

        if (i == nums.length) {
            return new ArrayList<>();
        }

        if (dp[i][prev + 1] != null) {
            return dp[i][prev + 1];
        }

        List<Integer> notPick = helper(nums, i + 1, prev);

        List<Integer> pick = new ArrayList<>();

        if (prev == -1 || nums[i] % nums[prev] == 0) {

            pick = new ArrayList<>(helper(nums, i + 1, i));

            pick.add(0, nums[i]);
        }

        if (pick.size() > notPick.size()) {
            dp[i][prev + 1] = pick;
        } else {
            dp[i][prev + 1] = notPick;
        }

        return dp[i][prev + 1];
    }
}