import java.util.*;

public class coins
 {

    static long binPow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                ans = ans * a;
            a = a * a;
            b >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            long ans = 0;
            long p = 0;

            for (int i = 0; i < n; i++) {
                ans += a[i];
                p += b[i];
            }

            long p1 = binPow(2, p);
            ans *= p1;

            System.out.println(ans);
        }
    }
}