import java.util.*;

class Solution {
    
    int N, M;
    char[][] map;
    int[] start, lever, exit;
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        
        N = maps.length;
        M = maps[0].length();
        
        map = new char[N][M];
        start = new int[2];
        lever = new int[2];
        exit = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (map[i][j] == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                } else if (map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        int res1 = bfs(start, lever);
        if (res1 == -1) return -1;
        int res2 = bfs(lever, exit);
        if (res2 == -1) return -1;
        
        return res1 + res2;
    }
    
    public int bfs(int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        
        q.add(start);
        visited[start[0]][start[1]] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                
                if (curr[0] == end[0] && curr[1] == end[1]) return cnt;
                
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
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