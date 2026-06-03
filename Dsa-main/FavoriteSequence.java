import java.util.*;

public class FavoriteSequence {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();

                long[] b = new long[n];
                long[] a = new long[n];

                for (int i = 0; i < n; i++) {
                    b[i] = scanner.nextLong();
                }

                int l = 0, r = n - 1;

                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) {
                        a[i] = b[l++];
                    } else {
                        a[i] = b[r--];
                    }
                }

                for (int i = 0; i < n; i++) {
                    System.out.print(a[i] + " ");
                }
                System.out.println();
            }
        }
    }
}