import java.util.*;

class Solution {
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    int len;
    int[][][] visited;
    
    public int solution(int[][] board) {
        
        len = board.length;
        visited = new int[len][len][4];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        
        for (int d = 0; d < 4; d++) {
            visited[0][0][d] = 0;
            dfs(0, 0, board, d);
        }
        
    int answer = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, visited[len-1][len-1][d]);
        }
        
        return answer;
    }
    
    
    public void dfs(int r, int c, int[][] board, int dir) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if (nr < 0 || nr >= len || nc < 0 || nc >= len) continue;
            if (board[nr][nc] == 1) continue;
            
            if (d == dir) {
                if (visited[r][c][dir] + 100 < visited[nr][nc][d]) {
                    visited[nr][nc][d] = visited[r][c][dir] + 100;
                    dfs(nr, nc, board, d);
                }
            } else {
                if (visited[r][c][dir] + 600 < visited[nr][nc][d]) {
                    visited[nr][nc][d] = visited[r][c][dir] + 600;
                    dfs(nr, nc, board, d);
                }
            }
        }   
    }
}