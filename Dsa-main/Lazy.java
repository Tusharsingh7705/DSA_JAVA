import java.util.*;

public class Lazy {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            long m = sc.nextLong();
            long c = sc.nextLong();

            long[] x = new long[n];
            long total_sum_x = 0;

            for (int i = 0; i < n; i++) {
                x[i] = sc.nextLong();
                total_sum_x += x[i];
            }

            long target = m * c;

            if (total_sum_x >= target) {
                System.out.println(0);
                return;
            }

            Arrays.sort(x);
            for (int i = 0; i < n / 2; i++) {
                long temp = x[i];
                x[i] = x[n - 1 - i];
                x[n - 1 - i] = temp;
            }

            long current_val = total_sum_x;
            int count = 0;

            for (int i = 0; i < n; i++) {
                current_val += x[i] * (c - 1);
                count++;

                if (current_val >= target) {
                    System.out.println(count);
                    return;
                }
            }

            System.out.println(count);
        }
    }
}