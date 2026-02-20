import java.util.*;

class Solution {
    
    int N, M;
    char[][] map;
    boolean[][] visited;
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        
        N = maps.length;
        M = maps[0].length();
        
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'X') visited[i][j] = true; 
            }
        }
        
        PriorityQueue<Integer> ans = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 'X' && !visited[i][j]) ans.add(bfs(i, j));
            }
        }
        
        int size = ans.size();
        int[] answer;
        if (size == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[size];
            for (int i = 0; i < size; i++) {
                answer[i] = ans.poll();
            }
        }
        
        return answer;
    }
    
    public int bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;
        
        int sum = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            sum += map[curr[0]][curr[1]] - '0';
            
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == 'X' || visited[nr][nc]) continue;
                
                visited[nr][nc] = true;
                q.add(new int[] {nr, nc});
            }
            
        }
        
        return sum;
    }
}