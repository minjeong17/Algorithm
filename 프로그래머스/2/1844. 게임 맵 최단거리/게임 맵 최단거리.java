import java.util.*;

class Solution {
    
    int[][] mapS;
    int nn, mm;
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        
        mapS = maps;
        nn = maps.length;
        mm = maps[0].length;
        
        return bfs(0, 0);
    }
    
    public int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[nn][mm];
        
        q.add(new int[] {r, c});
        visited[r][c] = true;
        
        int cnt = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                
                if (curr[0] == nn-1 && curr[1] == mm-1) return cnt;
                
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    
                    if (nr < 0 || nr >= nn || nc < 0 || nc >= mm) continue;
                    if (visited[nr][nc] || mapS[nr][nc] == 0) continue;
                    
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
            cnt++;
        }
        return -1;
    }
}