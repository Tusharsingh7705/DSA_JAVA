class Solution {
    public int helper(int amount ,int [] coins, int i,int dp[][]){
        if(amount==0){
            return 1;
        }
        if(i==coins.length){
            return 0;
            
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int pick=0;
        int notPick=0;

        if(coins[i]<=amount){
            pick=helper(amount-coins[i],coins,i,dp);
            
        }
        notPick=helper(amount,coins,i+1,dp);

        return dp[i][amount]= (pick+notPick);

    }
    public int change(int amount, int[] coins) {
        
        int i=coins.length;

        int [][] dp=new int[i][amount+1];

        for(int it[]:dp){
            Arrays.fill(it,-1);
        }          
        
         return helper(amount,coins,0,dp);
        
    }
}