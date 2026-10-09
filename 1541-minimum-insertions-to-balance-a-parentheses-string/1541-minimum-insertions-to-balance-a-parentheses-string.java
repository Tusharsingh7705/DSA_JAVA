class Solution {
    public int minInsertions(String s) {
        int open = 0, ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            else {
                //  make a "))"
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') i++;
                else ans++;

                // find its '('
                if (open > 0) open--;
                else ans++;
            }
        }

        return ans + open * 2;
    }
}