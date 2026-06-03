import java.io.*;
import java.util.*;

public class FerrisWheel {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] weight = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);

        int i = 0, j = n - 1;
        int count = 0;

        while (i <= j) {
            if (weight[i] + weight[j] <= x) {
                i++;
                j--;
            } else {
                j--;
            }
            count++;
        }

        System.out.println(count);
    }
}
