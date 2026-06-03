import java.util.*;

public class RemoveSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);

            boolean ok = true;
            for (int i = 1; i < n; i++) {
                if (a[i] - a[i - 1] > 1) {
                    ok = false;
                    break;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
        sc.close();
    }
}
