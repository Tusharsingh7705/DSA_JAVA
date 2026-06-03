import java.util.*;

public class Prefix {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            long[] arr = new long[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextLong();
            }

            long sum = 0;
            int ans = 1;

            for (int i = 0; i < N; i++) {
                sum += arr[i];

                long avg = sum / (i + 1);

                if (arr[i] > avg) {
                    break;
                }

                ans = i + 1;
            }

            System.out.println(ans);
        }
    }
}