import java.util.*;

public class Blocks {

    static final long MOD = 1000000007;

    static long binPow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) ans = (ans * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];

        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();

        sc.close();

        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long p = binPow(2, a[i]);
            ans = (ans * p % MOD + (p - 1 + MOD) % MOD) % MOD;

            long q = binPow(2, b[i]);
            ans = (ans * q) % MOD;
        }

        System.out.println(ans);
    }
}