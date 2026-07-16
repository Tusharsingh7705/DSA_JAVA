class Solution {
    public int findNumberOfLIS(int[] nums) {
        int count[] = new int[nums.length];
        int dp[] = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            dp[i] = 1;
            count[i] = 1;

        } 

        int maxi = 1;
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j] && 1+dp[j]>dp[i]){
                    dp[i] = 1+dp[j];
                    count[i] = count[j];
                }
                else if(nums[i]>nums[j] && 1+dp[j]==dp[i]){
                    count[i]+=count[j];
                }
                
            }
           maxi = Math.max(dp[i],maxi);

        }
        
        int nos = 0;
        for(int i = 0;i<dp.length;i++){
            if(dp[i]==maxi){
                nos+=count[i];
            }
        }

        return nos;
        
    }
}