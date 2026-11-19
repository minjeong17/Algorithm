import java.util.*;

class Solution {
    int n, m;
    char[][] st;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    boolean[][] visited;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        n = storage.length;
        m = storage[0].length();
        
        st = new char[n][m];
        for (int i = 0; i < n; i++) {
            st[i] = storage[i].toCharArray();
        }
        
        for (String req : requests) {
            char ch = req.charAt(0);
            if (req.length() == 1) {
                List<int[]> tmp = new ArrayList<>();
                visited = new boolean[n][m];
                for (int i = 0; i < n; i++) {
                    if (!visited[i][0] && st[i][0] == ch) {
                        visited[i][0] = true;
                        tmp.add(new int[] {i, 0});
                    } else if (!visited[i][0] && st[i][0] == '.') {
                        visited[i][0] = true;
                        List<int[]> t = find(i, 0, ch);
                        for (int[] tt : t) tmp.add(tt);
                    }
                    
                    if (!visited[i][m-1] && st[i][m-1] == ch) {
                        visited[i][m-1] = true;
                        tmp.add(new int[] {i, m-1});
                    } else if (!visited[i][m-1] && st[i][m-1] == '.') {
                        visited[i][m-1] = true;
                        List<int[]> t = find(i, m-1, ch);
                        for (int[] tt : t) tmp.add(tt);
                    }
                }
                
                for (int j = 0; j < m; j++) {
                    if (!visited[0][j] && st[0][j] == ch) {
                        visited[0][j] = true;
                        tmp.add(new int[] {0, j});
                    } else if (!visited[0][j] && st[0][j] == '.') {
                        visited[0][j] = true;
                        List<int[]> t = find(0, j, ch);
                        for (int[] tt : t) tmp.add(tt);
                    }
                    
                    if (!visited[n-1][j] && st[n-1][j] == ch) {
                        visited[n-1][j] = true;
                        tmp.add(new int[] {n-1, j});
                    } else if (!visited[n-1][j] && st[n-1][j] == '.') {
                        visited[n-1][j] = true;
                        List<int[]> t = find(n-1, j, ch);
                        for (int[] tt : t) tmp.add(tt);
                    }
                }
                
                answer += tmp.size();
                for (int[] t : tmp) {
                    st[t[0]][t[1]] = '.';
                }
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (st[i][j] == ch) {
                            st[i][j] = '.';
                            answer++;
                        }
                    }
                }
            }
        }
        
        return n * m - answer;
    }
    
    public List<int[]> find(int r, int c, char ch) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {r, c});
        visited[r][c] = true;
        
        List<int[]> tmp = new ArrayList<>();
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;
                
                visited[nr][nc] = true;
                if (st[nr][nc] == '.') q.add(new int[] {nr, nc});
                if (st[nr][nc] == ch) tmp.add(new int[] {nr, nc});
            }
        }
        
        return tmp;
    }
}