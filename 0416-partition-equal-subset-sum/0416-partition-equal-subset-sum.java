class Solution {
    public static boolean helper(int arr[],int index,int target,int dp[][]){
        if(index<0){
            if(target==0){
                return true;
            }
            return false;
        }
        if(dp[index][target]!=-1){
            return dp[index][target]==1?true:false;
        }            
        
        boolean notPick=helper(arr,index-1,target,dp);
        boolean pick=false;
        if(arr[index]<=target){
            pick=helper(arr,index-1,target-arr[index],dp);
        }
        boolean ans = pick|notPick;
        if(ans){
             dp[index][target] = 1;
             return true;
        }else{
            dp[index][target] = 0;
            return false;
        }

        
         
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
       
        int sum=0;
        for(int i=0; i<nums.length;i++){
            sum=sum+nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
         int[][] dp=new int[n][target+1];
         for(int it[]: dp){
            Arrays.fill(it,-1);
         }
        return helper(nums,nums.length-1,target,dp);    
        
    }
}