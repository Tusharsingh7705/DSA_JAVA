import java.io.*;
import java.util.*;

public class CountingRooms {

    static void dfs(char[][] mat, int i, int j) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == '#')
            return;

        mat[i][j] = '#';

        dfs(mat, i + 1, j);
        dfs(mat, i - 1, j);
        dfs(mat, i, j + 1);
        dfs(mat, i, j - 1);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] mat = new char[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                mat[i][j] = row.charAt(j);
            }
        }

        int rooms = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == '.') {
                    dfs(mat, i, j);
                    rooms++;
                }
            }
        }

        System.out.println(rooms);
    }
}
