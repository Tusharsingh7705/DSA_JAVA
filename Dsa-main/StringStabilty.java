import java.util.*;

public class StringStabilty {

    static int solve(String s) {
        if (s.length() < 2) return 0;

        Set<String> distinctPairs = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            String pair = "" + s.charAt(i) + s.charAt(i + 1);
            distinctPairs.add(pair);
        }
        return distinctPairs.size();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.next();
            int n = s.length();

            if (n < 2) {
                System.out.println(0);
                return;
            }

            int ans = 0;
            char[] arr = s.toCharArray();

            for (int i = 0; i < n - 1; i++) {
                char temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;

                ans = Math.max(ans, solve(new String(arr)));

                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }

            System.out.println(ans);
        }
    }
}