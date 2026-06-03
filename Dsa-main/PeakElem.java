import java.util.*;

public class PeakElem {

    static int[] val = new int[100005];
    static int[] L = new int[100005];
    static int[] R = new int[100005];
    static boolean[] removed = new boolean[100005];

    static boolean isPeak(int i, int n) {
        if (i <= 1 || i >= n || removed[i]) return false;
        return val[i] > val[L[i]] && val[i] > val[R[i]];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) {
            sc.close();
            return;
        }
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            val[i] = sc.nextInt();
            L[i] = i - 1;
            R[i] = i + 1;
            removed[i] = false;
        }
        R[n] = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 2; i < n; i++) {
            if (isPeak(i, n)) {
                q.offer(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (removed[curr] || !isPeak(curr, n)) continue;

            removed[curr] = true;
            count++;

            int leftNeigh = L[curr];
            int rightNeigh = R[curr];

            if (leftNeigh != 0) R[leftNeigh] = rightNeigh;
            if (rightNeigh != 0) L[rightNeigh] = leftNeigh;

            if (leftNeigh != 0 && isPeak(leftNeigh, n)) q.offer(leftNeigh);
            if (rightNeigh != 0 && isPeak(rightNeigh, n)) q.offer(rightNeigh);
        }

        System.out.println(count);
        sc.close();
    }
}