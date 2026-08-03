

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // Min-heap: (elevation, row, col)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});

        // Track visited cells
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        // Directions (up, down, left, right)
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Max elevation seen so far
        int maxElevation = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int elev = curr[0];
            int r = curr[1];
            int c = curr[2];

            // Update max elevation on path
            maxElevation = Math.max(maxElevation, elev);

            // If destination reached → return answer
            if (r == n - 1 && c == n - 1) {
                return maxElevation;
            }

            // Explore neighbors
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.offer(new int[]{grid[nr][nc], nr, nc});
                }
            }
        }

        return -1; // should never happen
    }
}
