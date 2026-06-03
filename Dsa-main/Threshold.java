import java.util.*;

public class Threshold {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            int i = 0;

            for (i = 0; i < n - 1; i++) {
                if (arr[i] + 1 > arr[i] + x) {
                    if (k > 0) {
                        k--;
                    } else {
                        break;
                    }
                }
            }

            System.out.println(i);
        }
    }
}