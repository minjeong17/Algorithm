import java.util.*;

class Solution {
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        int nRow = storage.length;
        int nCol = storage[0].length();
        
        int answer = 0;

        char[][] maps = new char[nRow+2][nCol+2];
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                maps[i+1][j+1] = storage[i].charAt(j);
                if (maps[i+1][j+1] != '\u0000') answer++;
            }
        }
        
        for (String request : requests) {
            List<int[]> tmp = new ArrayList<>();
            char req = request.charAt(0);
            if (request.length() == 1) {
                boolean[][] outsides = find(maps, nRow, nCol);
                for (int i = 1; i <= nRow; i++) {
                    for (int j = 1; j <= nCol; j++) {
                        if (maps[i][j] == req) {
                            boolean chk = false;
                            for (int d = 0; d < 4; d++) {
                                int nr = i + dr[d];
                                int nc = j + dc[d];
                                
                                if (outsides[nr][nc]) {
                                    chk = true;
                                    break;
                                }
                            }
                            if (chk) {
                                tmp.add(new int[] {i, j});
                            }
                        }
                    }
                }
            } else {
                for (int i = 1; i <= nRow; i++) {
                    for (int j = 1; j <= nCol; j++) {
                        if (maps[i][j] == req) {
                            tmp.add(new int[] {i, j});
                        }
                    }
                }
            }
            
            for (int i = 0; i < tmp.size(); i++) {
                int[] curr = tmp.get(i);
                maps[curr[0]][curr[1]] = '\u0000';
                answer--;
            }
        }
        
        return answer;
    }
    
    public boolean[][] find(char[][] maps, int nRow, int nCol) {
        boolean[][] outside = new boolean[nRow+2][nCol+2];
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i <= nRow+1; i++) {
            if (maps[i][0] == '\u0000') {
                outside[i][0] = true;
                q.add(new int[] {i, 0});
            }
            if (maps[i][nCol+1] == '\u0000') {
                outside[i][nCol+1] = true;
                q.add(new int[] {i, nCol+1});
            }
        }
        
        for (int j = 0; j <= nCol+1; j++) {
            if (maps[0][j] == '\u0000') {
                outside[0][j] = true;
                q.add(new int[] {0, j});
            }
            if (maps[nRow+1][j] == '\u0000') {
                outside[nRow+1][j] = true;
                q.add(new int[] {nRow+1, j});
            }
        }
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                
                if (nr < 0 || nr >= nRow+2 || nc < 0 || nc >= nCol+2) continue;
                if (outside[nr][nc] || maps[nr][nc] != '\u0000') continue;
            
                outside[nr][nc] = true;
                q.add(new int[] {nr, nc});
            }
        }
        
        return outside;
    }
}