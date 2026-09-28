import java.util.*;

class Solution {
    int[][] maps;
    int m, n;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int solution(int[][] maps) {
        this.maps = maps;
        m = maps.length;
        n = maps[0].length;
        
        return bfs(0, 0);
    }
    
    public int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        q.add(new int[] {r, c});
        visited[r][c] = true;
        
        int answer = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
            
                if (curr[0] == m - 1 && curr[1] == n - 1) return answer;

                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (visited[nr][nc] || maps[nr][nc] == 0) continue;

                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
            
            answer++;
        }
        
        return -1;
    }
}