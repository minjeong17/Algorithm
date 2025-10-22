import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        
        int[] start = new int[2];
        int[] end = new int[2];
        
        char[][] map = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                char ch = board[i].charAt(j);
                map[i][j] = ch;
                if (ch == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if (ch == 'G') {
                    end[0] = i;
                    end[1] = j;
                }
            } 
        }
        return find(map, start, end);
    }
    
    // 상하좌우
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int find(char[][] map, int[] start, int[] end) {
        int rLen = map.length;
        int cLen = map[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rLen][cLen];
        q.add(new int[] {start[0], start[1]});
        visited[start[0]][start[1]] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                
                if (r == end[0] && c == end[1]) return cnt;
                
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= rLen || nc < 0 || nc >= cLen) continue;
                    if (map[nr][nc] == 'D') continue;

                    while (true) {
                        int nnr = nr + dr[d];
                        int nnc = nc + dc[d];

                        if (nnr == rLen || nnr == -1 || nnc == cLen || nnc == -1 || map[nnr][nnc] == 'D') {
                            if (!visited[nr][nc]) {
                                q.add(new int[] {nr, nc});
                                visited[nr][nc] = true;
                            }
                            break;
                        } 

                        nr = nnr;
                        nc = nnc;
                    }
                }
            }
            cnt++;
        }
        
        return -1;
    }
}