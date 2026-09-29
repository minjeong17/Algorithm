import java.util.*;

class Solution {
    char[][] map;
    int m, n, rR, cR, rG, cG;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int solution(String[] board) {
        int answer = 0;
        
        m = board.length;
        n = board[0].length();
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            String str = board[i];
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
                
                if (map[i][j] == 'R') {
                    rR = i;
                    cR = j;
                }
                
                if (map[i][j] == 'G') {
                    rG = i;
                    cG = j;
                }
            }
        }
        
        return bfs(rR, cR);
    }
    
    public int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        q.add(new int[] {r, c});
        visited[r][c] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                
                if (curr[0] == rG && curr[1] == cG) return cnt;
                
                for (int d = 0; d < 4; d++) {
                    int prevR = curr[0]; int prevC = curr[1];
                    int nr; int nc;
                    while (true) {
                        nr = prevR + dr[d];
                        nc = prevC + dc[d];
                        
                        if ((nr < 0 || nr >= m || nc < 0 || nc >= n) || map[nr][nc] == 'D') {
                            nr -= dr[d];
                            nc -= dc[d];
                            break;
                        }
                                                
                        prevR = nr;
                        prevC = nc;
                    }
                    
                    if (visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
            
            cnt++;
        }
        
        return -1;
    }
}