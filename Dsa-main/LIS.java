import java.io.*;
import java.util.*;

public class LIS
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> tails = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());

            int l = 0, r = tails.size();

            while (l < r) {
                int mid = l + (r - l) / 2;

                if (tails.get(mid) >= x) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            if (l == tails.size()) {
                tails.add(x);
            } else {
                tails.set(l, x);
            }
        }

        System.out.println(tails.size());
    }
}