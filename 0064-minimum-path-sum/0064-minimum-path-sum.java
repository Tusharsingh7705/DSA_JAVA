class Solution {
    public int helper(int [][]grid,int n,int m,int [][]dp){
        if(n>=grid.length||m>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(n==grid.length-1&&m==grid[0].length-1){
            return grid[n][m];
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        int down=helper(grid,n,m+1,dp);
        int right=helper(grid,n+1,m,dp);

        return dp[n][m]  =grid[n][m]+Math.min(down,right);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][]dp=new int [n+1][m+1];

        for(int []it:dp){
            Arrays.fill(it,-1);
        }

        return helper(grid,0,0,dp);
        
    }
}