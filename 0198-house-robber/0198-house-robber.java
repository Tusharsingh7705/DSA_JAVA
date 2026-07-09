class Solution {

    int n;    
    public int helper(int[] nums, int i,int []dp) {

        
        if (i >= n) {
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        
        int steal = nums[i] + helper(nums, i + 2,dp);

        int skip = helper(nums, i + 1,dp);

        return dp[i]= Math.max(steal, skip);
    }

    public int rob(int[] nums) {        
        n = nums.length;
        int []dp=new int [n+1];
        Arrays.fill(dp,-1);
       
        return helper(nums, 0,dp);
    }
}
