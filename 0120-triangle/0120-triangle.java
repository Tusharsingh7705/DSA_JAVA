class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int j = 0; j < triangle.get(n - 1).size(); j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int curr = triangle.get(i).get(j);
                int include = dp[i + 1][j];
                int exclude = dp[i + 1][j + 1];
                dp[i][j] = curr + Math.min(include, exclude);
            }
        }

        return dp[0][0];
    }
}
