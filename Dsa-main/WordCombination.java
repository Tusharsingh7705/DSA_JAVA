import java.util.*;

public class WordCombination {

    private static class Node {
        Node[] next = new Node[26];
        boolean end;
    }

    private final long MOD = 1000000007;
    private Node root = new Node();

    private void insert(String w) {
        Node cur = root;
        for (int i = 0; i < w.length(); i++) {
            int c = w.charAt(i) - 'a';
            if (cur.next[c] == null)
                cur.next[c] = new Node();
            cur = cur.next[c];
        }
        cur.end = true;
    }

    public void solve() {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine().trim();
            int n = s.length();

            int k = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < k; i++) {
                insert(sc.nextLine().trim());
            }

            long[] dp = new long[n + 1];
            dp[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                Node cur = root;

                for (int j = i; j < n; j++) {
                    int c = s.charAt(j) - 'a';
                    if (cur.next[c] == null)
                        break;

                    cur = cur.next[c];
                    if (cur.end) {
                        dp[i] = (dp[i] + dp[j + 1]) % MOD;
                    }
                }
            }

            System.out.println(dp[0]);
        }
    }

    public static void main(String[] args) {
        new WordCombination().solve();
    }
}
