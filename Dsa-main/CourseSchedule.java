import java.io.*;
import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] inDegree = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            inDegree[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            count++;

            for (int next : adjList.get(current)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (count != n) {
            System.out.println("IMPOSSIBLE");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int course : result) {
                sb.append(course).append(" ");
            }
            System.out.println(sb);
        }
    }
}
