class Solution {
    Integer[][] dp;

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new Integer[n][m];

        int lcs = LCS(word1, word2, 0, 0);
        return (n - lcs) + (m - lcs);
    }

    int LCS(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length()) return 0;

        if (dp[i][j] != null) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + LCS(s1, s2, i + 1, j + 1);

        int skip1 = LCS(s1, s2, i + 1, j);
        int skip2 = LCS(s1, s2, i, j + 1);

        return dp[i][j] = Math.max(skip1, skip2);
    }
}
