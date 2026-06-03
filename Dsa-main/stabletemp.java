import java.util.*;

public class stabletemp {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            long[] t = new long[n];

            for (int i = 0; i < n; i++) {
                t[i] = sc.nextLong();
            }

            if (n <= 1) {
                System.out.println(0);
                return;
            }

            long[] res = Arrays.copyOf(t, n);

            for (int i = 1; i < n; i++) {
                if (res[i] > res[i - 1] + 1) {
                    res[i] = res[i - 1] + 1;
                }
            }

            for (int i = n - 2; i >= 0; i--) {
                if (res[i] > res[i + 1] + 1) {
                    res[i] = res[i + 1] + 1;
                }
            }

            long totalOperations = 0;
            for (int i = 0; i < n; i++) {
                totalOperations += (t[i] - res[i]);
            }

            System.out.println(totalOperations);
        }
    }
}