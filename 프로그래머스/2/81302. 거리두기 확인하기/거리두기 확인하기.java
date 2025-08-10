import java.util.*;

class Solution {
    
    // 상우하좌
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int i = 0; i < 5; i++) {
            if (check(places[i])) answer[i] = 1;
        }
        
        return answer;
    }
    
    public boolean check(String[] place) {
        
        char[][] p = new char[5][5];
        for(int i = 0; i < 5; i++) {
            p[i] = place[i].toCharArray();
        }
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (p[i][j] == 'P') {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        
                        if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                        
                        if (p[nr][nc] == 'X') continue;
                        else if (p[nr][nc] == 'P') return false;
                        else {
                            for (int dd = 0; dd < 4; dd++) {
                                if (dd == (d + 2) % 4) continue;
                                
                                int nnr = nr + dr[dd];
                                int nnc = nc + dc[dd];
                                
                                if (nnr < 0 || nnr >= 5 || nnc < 0 || nnc >= 5) continue;
                                if (p[nnr][nnc] == 'P') return false;
                            }
                        }
                    }

                }
            }
        }
        
        return true;
    }
}