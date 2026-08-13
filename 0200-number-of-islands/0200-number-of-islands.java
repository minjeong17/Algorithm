import java.util.*;

class Solution {
    char[][] grid;
    int lenR, lenC;
    boolean[][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        this.grid = grid;
        lenR = grid.length;
        lenC = grid[0].length;

        int answer = 0;
        visited = new boolean[lenR][lenC];
        for (int i = 0; i < lenR; i++) {
            for (int j = 0; j < lenC; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(i, j);
                    answer++;
                }
            }
        }

        return answer;
    }

    public void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];

                if (nr < 0 || nr >= lenR || nc < 0 || nc >= lenC) continue;
                if (visited[nr][nc] || grid[nr][nc] == '0') continue;

                visited[nr][nc] = true;
                q.add(new int[] {nr, nc});
            }
        }
    }
}