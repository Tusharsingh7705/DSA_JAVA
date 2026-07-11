class Solution {
    public int helper(int []nums,int i,int sum,int target,int [][]dp){
        if(i==nums.length){
            if(sum==target){
                return 1;
            }
            return 0;
        }
        int shifted=sum+1000;
        if(dp[i][shifted]!=-1){
            return dp[i][shifted];
        }

        int pick=helper(nums,i+1,sum+nums[i],target,dp);
        int notpick=helper(nums,i+1,sum-nums[i],target,dp);

        return dp[i][shifted] =pick+notpick;
    }
    public int findTargetSumWays(int[] nums, int target) {

        int n=nums.length;

        int [][]dp=new int [n][2001];
        for(int []it:dp){
            Arrays.fill(it,-1);
        }
        return helper(nums,0,0,target,dp);
        
    }
}

 
