class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, nums.length);

        List<List<Integer>> L = new ArrayList<>();
        List<List<Integer>> R = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            L.add(new ArrayList<>());
            R.add(new ArrayList<>());
        }

        for (int mask = 0; mask < (1 << n); mask++) {
            int count = Integer.bitCount(mask);
            int sumL = 0, sumR = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sumL += left[i];
                    sumR += right[i];
                }
            }
            L.get(count).add(sumL);
            R.get(count).add(sumR);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(R.get(i));
        }

        int total = 0;
        for (int x : nums) total += x;

        int target = total / 2;
        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {
            List<Integer> listL = L.get(k);
            List<Integer> listR = R.get(n - k);

            for (int sumL : listL) {
                int needed = target - sumL;

                List<Integer> arr = listR;

                int idx = Collections.binarySearch(arr, needed);
                if (idx < 0) idx = -idx - 1;

                if (idx < arr.size()) {
                    int sum = sumL + arr.get(idx);
                    ans = Math.min(ans, Math.abs((total - sum) - sum));
                }
                if (idx - 1 >= 0) {
                    int sum = sumL + arr.get(idx - 1);
                    ans = Math.min(ans, Math.abs((total - sum) - sum));
                }
            }
        }

        return ans;
    }
}
