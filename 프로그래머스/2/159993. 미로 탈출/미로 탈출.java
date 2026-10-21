import java.util.*;

class Solution {
    int n, m;
    char[][] map;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int solution(String[] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        
        int startR = 0; int startC = 0;
        int leverR = 0; int leverC = 0;
        int exitR = 0; int exitC = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
                
                if (map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                } else if (map[i][j] == 'L') {
                    leverR = i;
                    leverC = j;
                } else if (map[i][j] == 'E') {
                    exitR = i;
                    exitC = j;
                }
            }
        }
        
        int toLever = bfs(startR, startC, leverR, leverC);
        if (toLever == -1) return -1;
        
        int toExit = bfs(leverR, leverC, exitR, exitC);
        if (toExit == -1) return -1;
        
        return toLever + toExit;
    }
    
    public int bfs(int startR, int startC, int goalR, int goalC) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new int[] {startR, startC});
        visited[startR][startC] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                
                if (curr[0] == goalR && curr[1] == goalC) return cnt;
                
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if (visited[nr][nc] || map[nr][nc] == 'X') continue;
                    
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
                
            }
            
            cnt++;
        }
        
        return -1;
    }
}