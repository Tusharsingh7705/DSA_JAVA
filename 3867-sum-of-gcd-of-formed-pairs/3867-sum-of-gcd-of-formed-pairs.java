class Solution {
    public long gcdSum(int[] nums) {
        int [] gc=nums;
        int n=nums.length;
        int [] prefix=new int [n];

        int mx=0;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,nums[i]);
            prefix[i]=gcd(nums[i],mx);
        }
        Arrays.sort(prefix);

        long sum=0;
        int l=0,r=n-1;
        while(l<r){
            sum+=gcd(prefix[l],prefix[r]);

            l++;
            r--;
        }
        return sum;
    }
    int gcd(int a,int b){
        while(b!=0){
            int t=a%b;
            a=b;b=t;
        }
        return a;
    }
}