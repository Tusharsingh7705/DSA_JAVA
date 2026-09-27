class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;

        for (int num : nums) {
            if (num == 0) zero++;
        }

        for (int num : nums) {
            if (num == 1) one++;
        }

        for (int num : nums) {
            if (num == 2) two++;
        }

        int idx = 0;

        while (zero-- > 0) nums[idx++] = 0;
        while (one-- > 0) nums[idx++] = 1;
        while (two-- > 0) nums[idx++] = 2;
    }
}