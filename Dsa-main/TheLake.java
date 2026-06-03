import java.util.*;

public class TheLake {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] grid = new int[n][m];
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int[] dx = { 1, -1, 0, 0 };
            int[] dy = { 0, 0, 1, -1 };
            // lakes made

            long ans = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if (grid[i][j] > 0 && !visited[i][j]) {

                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[] { i, j });
                        visited[i][j] = true;

                        long volume = 0;

                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            int x = cur[0], y = cur[1];

                            volume += grid[x][y];

                            for (int d = 0; d < 4; d++) {
                                int nx = x + dx[d];
                                int ny = y + dy[d];

                                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                                    if (!visited[nx][ny] && grid[nx][ny] > 0) {
                                        visited[nx][ny] = true;
                                        q.add(new int[] { nx, ny });
                                    }
                                }
                            }
                        }

                        ans = Math.max(ans, volume);
                    }
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
