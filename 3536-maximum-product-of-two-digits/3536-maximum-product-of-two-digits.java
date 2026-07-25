class Solution {
    public int maxProduct(int n) {
        int max = -1;
        String str = n + "";
        for(int i = 0 ; i < str.length() ; i++){
            for(int j = i + 1 ; j < str.length() ; j++){
                int d1 = str.charAt(i) - '0';
                int d2 = str.charAt(j) - '0';
                max = Math.max(max , d1 * d2);
            }
        }
        return max;
    }
}