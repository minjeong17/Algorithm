import java.util.*;

class Solution {
    char[][] board;
    String word;
    int n, m;
    boolean[][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;

        n = board.length;
        m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[n][m];
                    visited[i][j] = true;
                    if (dfs(i, j, 1)) return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int r, int c, int idx) {
        if (idx == word.length()) return true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;

            if (board[nr][nc] == word.charAt(idx)) {
                visited[nr][nc] = true;
                if (dfs(nr, nc, idx+1)) return true;
                visited[nr][nc] = false;
            }
        }

        return false;
    }
}