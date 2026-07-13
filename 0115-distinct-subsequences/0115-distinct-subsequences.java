class Solution {
    Integer[][] dp;

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        dp = new Integer[n][m];
        return solve(s, t, 0, 0);
    }

    int solve(String s, String t, int i, int j) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;

        if (dp[i][j] != null) return dp[i][j];

        int ways = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ways += solve(s, t, i + 1, j + 1);
        }
        ways += solve(s, t, i + 1, j);

        return dp[i][j] = ways;
    }
}
