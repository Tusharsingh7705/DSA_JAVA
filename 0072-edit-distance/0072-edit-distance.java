

class Solution {

    int[][] dp;

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];

        
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return solve(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    private int solve(String w1, String w2, int i, int j) {

        
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        
        if (dp[i][j] != -1) return dp[i][j];

        
        if (w1.charAt(i) == w2.charAt(j)) {
            return dp[i][j] = solve(w1, w2, i - 1, j - 1);
        }

        
        int insert = solve(w1, w2, i, j - 1);
        int delete = solve(w1, w2, i - 1, j);
        int replace = solve(w1, w2, i - 1, j - 1);

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}

// class Solution {
//     public int minDistance(String word1, String word2) {
//         return solve(word1, word2, word1.length() - 1, word2.length() - 1);
//     }

//     private int solve(String w1, String w2, int i, int j) {
        
//         if (i < 0) return j + 1; 
//         if (j < 0) return i + 1; 

        
//         if (w1.charAt(i) == w2.charAt(j)) {
//             return solve(w1, w2, i - 1, j - 1);
//         }

        
//         int insert = solve(w1, w2, i, j - 1);
//         int delete = solve(w1, w2, i - 1, j);
//         int replace = solve(w1, w2, i - 1, j - 1);

//         return 1 + Math.min(insert, Math.min(delete, replace));
//     }
// }
