class Solution {

    int n;
    int[] nums;
    int[] dp;

    public int helper(int index) {

        if (index >= n - 1) {
            return 0; 
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int min = Integer.MAX_VALUE;

        for (int j = 1; j <= nums[index]; j++) {
            if (index + j < n) {
                int next = helper(index + j);
                if (next != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + next);
                }
            }
        }

        dp[index] = min;
        return min;
    }

    public int jump(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        dp = new int[n];

        for (int i = 0; i < n; i++) dp[i] = -1;

        return helper(0);
    }
}





// class Solution {

//     int n;
//     int[] nums;
//     int[][] dp;

//     public int helper(int index, int jumps) {
//         if (index >= n - 1) {
//             return jumps;
//         }
//         if(dp[index][jumps]!=-1){
//             return dp[index][jumps];
//         }

//         int min = Integer.MAX_VALUE;

//         for (int i = 1; i <= nums[index]; i++) {
//             min = Math.min(min, helper(index + i, jumps + 1));
//         }
//         dp[index][jumps]=min; 
//         return min;
//     }

//     public int jump(int[] nums) {
//         this.n = nums.length;
//         this.nums = nums;
//         dp=new int[n][n+1];

//         for(int i=0;i<n;i++){
//             for(int j=0;j<=n;j++){

//                 dp[i][j]=-1;
//             }
//         }
//         return helper(0, 0);
//     }
// }
