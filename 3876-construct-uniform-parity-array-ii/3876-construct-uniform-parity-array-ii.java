class Solution {
    public boolean uniformArray(int[] nums1) {
        int mini = Integer.MAX_VALUE;
        boolean odd = false;

        for(int t : nums1){
            if(t % 2 == 1){
                odd = true;
                mini = Math.min(mini, t);
            }
        }

        if(!odd) return true;

        for(int t : nums1){
            if(t % 2 == 0 && mini > t) return false;
        }

        return true;
    }
}