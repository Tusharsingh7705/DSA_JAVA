class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return count(0, 0, grid, dp, m, n);
    }

    private int count(int i, int j, int[][] grid, int[][] dp, int m, int n) {
        if (i >= m || j >= n) return 0;
        if (grid[i][j] == 1) return 0;

        if (i == m - 1 && j == n - 1) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        int down = count(i + 1, j, grid, dp, m, n);
        int right = count(i, j + 1, grid, dp, m, n);

        return dp[i][j] = down + right;
    }
}
