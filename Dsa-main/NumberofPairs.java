public class NumberofPairs {
    public static void main(String[] args) {
        int[] nums = { 5, 1, 2 };
        int l = 4;
        int r = 7;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum >= l && sum <= r) {
                    System.out.println("Pair: (" + nums[i] + ", " + nums[j] + ") with sum: " + sum);
                }
            }
        }
    }

}
