import java.util.*;

class Solution {
    
    int[][] maps;
    int n, m;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
   
    public int solution(int[][] maps) {
        this.maps = maps;
        n = maps.length;
        m = maps[0].length;
        
        return bfs();
    }
    
    public int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new int[] {0, 0});
        visited[0][0] = true;
        
        int cnt = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                
                if (curr[0] == n-1 && curr[1] == m-1) {
                    return cnt;
                }
                
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if (visited[nr][nc] || maps[nr][nc] == 0) continue;
                    
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
            cnt++;
        }
        
        return -1;
    }
}