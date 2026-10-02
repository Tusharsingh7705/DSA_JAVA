class Solution {
    List<String>[][] dp;
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dp = new ArrayList[n + 1][n + 1];
        return helper(0, 0);
    }

    private List<String> helper(int open, int close) {

        if (open == n && close == n) {
            List<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        
        if (dp[open][close] != null) {
            return dp[open][close];
        }

        List<String> result = new ArrayList<>();

      
        if (open < n) {
            for (String s : helper(open + 1, close)) {
                result.add("(" + s);
            }
        }

       
        if (close < open) {
            for (String s : helper(open, close + 1)) {
                result.add(")" + s);
            }
        }

        dp[open][close] = result;
        return result;
    }
}


// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> result = new ArrayList<>();
//         helper(0, 0, n, "", result);
//         return result;
//     }

//     private void helper(int open, int close, int n, String valid, List<String> result) {
        
//         if (open == n && close == n) {
//             result.add(valid);
//             return;
//         }

        
//         if (open < n) {
//             helper(open + 1, close, n, valid + "(", result);
//         }

        
//         if (close < open) {
//             helper(open, close + 1, n, valid + ")", result);
//         }
//     }
// }
