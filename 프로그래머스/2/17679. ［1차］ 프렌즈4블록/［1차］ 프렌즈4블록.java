import java.util.*;

class Solution {
    
    boolean[][] chk;
    char[][] chBoard;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        chBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                chBoard[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            chk = new boolean[m][n];
            
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    if (chBoard[i][j] != '-' && (chBoard[i][j] == chBoard[i][j+1]
                       && chBoard[i][j+1] == chBoard[i+1][j+1]
                       && chBoard[i+1][j+1] == chBoard[i+1][j])) {
                        chk[i][j] = true;
                        chk[i+1][j] = true;
                        chk[i+1][j+1] = true;
                        chk[i][j+1] = true;
                    }
                }
            }
                    
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (chk[i][j]) {
                        cnt++;
                        fillBd(i, j, m);
                    }
                }
            }
            
            if (cnt == 0) break;
            
            answer += cnt;
            
        }
        
        return answer;
    }
    
    public void fillBd(int r, int c, int m) {
        for (int i = r; i >= 0; i--) {
            if (i != 0) 
                chBoard[i][c] = chBoard[i-1][c];
        }
        
        chBoard[0][c] = '-';
    }
}