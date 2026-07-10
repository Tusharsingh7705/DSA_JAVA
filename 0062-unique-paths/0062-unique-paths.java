class Solution {
    public int helper(int i ,int j,int m,int n,int [][]dp){
        if (i == m - 1 && j == n - 1) return 1;
        if (i >= m || j >= n) return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }


        int right=helper(i,j+1,m,n,dp);
        int down=helper(i+1,j,m,n,dp);
        return dp[i][j]= right+down;
    }
    public int uniquePaths(int m, int n) {
        int [][] dp=new int [m][n];
        for(int []it:dp){
            Arrays.fill(it,-1);
        }


        return helper(0,0,m,n,dp);
        
    }
}