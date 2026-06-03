import java.io.*;
import java.util.*;

public class Monsters {
    static int n, m;
    static char[][] grid;
    static int[][] monsterTime;
    static int[][] playerTime;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static char[] dir = { 'D', 'U', 'R', 'L' };
    static int[][] parentDir;
    static int[][] parentX;
    static int[][] parentY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new char[n][m];
        monsterTime = new int[n][m];
        playerTime = new int[n][m];
        parentDir = new int[n][m];
        parentX = new int[n][m];
        parentY = new int[n][m];

        Queue<int[]> monsterQ = new LinkedList<>();
        Queue<int[]> playerQ = new LinkedList<>();

        int sx = 0, sy = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(monsterTime[i], Integer.MAX_VALUE);
            Arrays.fill(playerTime[i], -1);
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'M') {
                    monsterQ.add(new int[] { i, j });
                    monsterTime[i][j] = 0;
                }
                if (grid[i][j] == 'A') {
                    sx = i;
                    sy = j;
                }
            }
        }

        // BFS for monsters
        while (!monsterQ.isEmpty()) {
            int[] cur = monsterQ.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
                        grid[nx][ny] != '#' &&
                        monsterTime[nx][ny] == Integer.MAX_VALUE) {
                    monsterTime[nx][ny] = monsterTime[x][y] + 1;
                    monsterQ.add(new int[] { nx, ny });
                }
            }
        }

        // BFS for player
        playerQ.add(new int[] { sx, sy });
        playerTime[sx][sy] = 0;

        int ex = -1, ey = -1;

        while (!playerQ.isEmpty()) {
            int[] cur = playerQ.poll();
            int x = cur[0], y = cur[1];

            if (x == 0 || y == 0 || x == n - 1 || y == m - 1) {
                ex = x;
                ey = y;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
                        grid[nx][ny] != '#' &&
                        playerTime[nx][ny] == -1 &&
                        playerTime[x][y] + 1 < monsterTime[nx][ny]) {

                    playerTime[nx][ny] = playerTime[x][y] + 1;
                    parentDir[nx][ny] = d;
                    parentX[nx][ny] = x;
                    parentY[nx][ny] = y;
                    playerQ.add(new int[] { nx, ny });
                }
            }
        }

        if (ex == -1) {
            System.out.println("NO");
            return;
        }

        StringBuilder path = new StringBuilder();
        int cx = ex, cy = ey;

        while (cx != sx || cy != sy) {
            int d = parentDir[cx][cy];
            path.append(dir[d]);
            int px = parentX[cx][cy];
            int py = parentY[cx][cy];
            cx = px;
            cy = py;
        }

        path.reverse();

        System.out.println("YES");
        System.out.println(path.length());
        System.out.println(path.toString());
    }
}
