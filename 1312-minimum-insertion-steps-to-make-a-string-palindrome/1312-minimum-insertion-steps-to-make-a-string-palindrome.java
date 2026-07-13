class Solution {
    public int helper(String s,int i,int j,int [][]dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=helper(s,i+1,j-1,dp);
        }
        int left=helper(s,i+1,j,dp);
        int right=helper(s,i,j-1,dp);

        return dp[i][j]=1+Math.min(left,right);
    }
    public int minInsertions(String s) {
        int n=s.length();
        int [][]dp=new int [n+1][n+1];
        for(int it[]:dp){
            Arrays.fill(it,-1);
        }
        return helper(s,0,n-1,dp);
        
    }
}