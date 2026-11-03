import java.util.*;

class Solution {
    int n, m;
    char[][] map;
    boolean[][] visited;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        List<Integer> sumList = new ArrayList<>();
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    int sum = bfs(i, j);
                    if (sum != -1) sumList.add(sum);
                }
            }
        }
        
        if (sumList.size() == 0) return new int[] {-1};
        
        Collections.sort(sumList);
        int[] answer = new int[sumList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = sumList.get(i);
        }
        
        return answer;
    }
    
    public int bfs(int r, int c) {
        Queue<int[]> pq = new LinkedList<>();
        
        pq.add(new int[] {r, c});
        visited[r][c] = true;
        
        int sum = 0;
        sum += map[r][c] - '0';
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (visited[nr][nc] || map[nr][nc] == 'X') continue;
                
                sum += map[nr][nc] - '0';
                visited[nr][nc] = true;
                pq.add(new int[] {nr, nc});
            }
        }
        
        return sum == 0 ? -1 : sum;
    }
}