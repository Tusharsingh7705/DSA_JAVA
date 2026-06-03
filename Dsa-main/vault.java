import java.util.*;

public class vault {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        int maxi = arr[0];

        for (int i = 1; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
            if (arr[i] < maxi) {
                ans += maxi - arr[i];
            }
        }

            System.out.println(ans);
        }
    }
}