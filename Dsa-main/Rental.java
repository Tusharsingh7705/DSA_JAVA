import java.util.*;

public class Rental {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int[] P = new int[n];
            int[] R = new int[m];

            for (int i = 0; i < n; i++) P[i] = sc.nextInt();
            for (int i = 0; i < m; i++) R[i] = sc.nextInt();

            Arrays.sort(P);
            Arrays.sort(R);

            int i = 0;
            int j = 0;
            int ans = 0;

            while (i < n && j < m) {
                if (R[j] >= P[i]) {
                    ans++;
                    i++;
                    j++;
                } else if (k > 0 && (long) R[j] * 2 >= P[i]) {
                    ans++;
                    k--;
                    i++;
                    j++;
                } else {
                    j++;
                }
            }

            System.out.println(ans);
        }
    }
}