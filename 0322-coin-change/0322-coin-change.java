class Solution {
    public int helper(int []coins,int amount,int i,int [][]dp){
        if(amount==0){
            return 0;
        }
        if(i==coins.length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int pick=Integer.MAX_VALUE;
        int notPick=Integer.MAX_VALUE;

        if(coins[i]<=amount){
            int res=helper(coins,amount-coins[i],i,dp);
            if(res!=Integer.MAX_VALUE){
                pick=1+res;
            }
        }
        notPick=helper(coins,amount,i+1,dp);

        return dp[i][amount]= Math.min(pick,notPick);
    }


    public int coinChange(int[] coins, int amount) {
        int n=coins.length;

        int[][]dp=new int [n][amount+1];
        for(int []it:dp){
            Arrays.fill(it,-1);
        }

        int ans=helper(coins,amount,0,dp);

        if(ans==Integer.MAX_VALUE){
            return -1;
        }else{
            return ans;
        }

        
        
    }
}