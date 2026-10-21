import java.util.*;

class Solution {
    int n, m, goalR, goalC;
    char[][] b;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int solution(String[] board) {
        int answer = 0;
        
        n = board.length;
        m = board[0].length();
        
        int startR = 0; int startC = 0;
        goalR = 0; goalC = 0;
        b = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = board[i].charAt(j);
                
                if (b[i][j] == 'R') {
                    startR = i;
                    startC = j;
                } else if (b[i][j] == 'G') {
                    goalR = i;
                    goalC = j;
                }
            }
        }
        
        return bfs(startR, startC);
    }
    
    public int bfs(int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new int[] {startR, startC});
        visited[startR][startC] = true;
        
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                
                if (curr[0] == goalR && curr[1] == goalC) return ans;
                
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0];
                    int nc = curr[1];
                    
                    while (true) {
                        int nextR = nr + dr[d];
                        int nextC = nc + dc[d];
                        
                        if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m || b[nextR][nextC] == 'D') break;
                           
                        nr = nextR;
                        nc = nextC;
                    }
                    
                    if (visited[nr][nc]) continue;
                                        
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
            
            ans++;
        }
        
        return -1;
    }
}