class Solution {
    public int helper(int i,int prev,int []nums,int [][]dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }
        int pick=0;
        if(prev==-1||nums[i]>nums[prev]){
            pick=1+helper(i+1,i,nums,dp);
        }
        int notPick=helper(i+1,prev,nums,dp);

        return dp[i][prev+1]=Math.max(pick,notPick);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int [][]dp=new int [n][n+1];

        for(int it[]:dp){
            Arrays.fill(it,-1);
        }
        return helper(0,-1,nums,dp);
        
    }
}