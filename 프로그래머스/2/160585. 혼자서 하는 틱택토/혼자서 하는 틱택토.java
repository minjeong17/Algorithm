import java.util.*;

class Solution {
    char[][] b;
    public int solution(String[] board) {
        int answer = 0;
        
        int cntO = 0;
        int cntX = 0;
        
        b = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = board[i].charAt(j);
                
                if (b[i][j] == 'O') cntO++;
                else if (b[i][j] == 'X') cntX++;
            }
        }
        
        boolean winO = check('O');
        boolean winX = check('X');
        
        if (cntO == cntX + 1) {
            if (winX) return 0;
            else return 1;
        } else if (cntO == cntX) {
            if ((!winO && winX) || (!winO && !winX)) return 1;
            else return 0;
        } else return 0;
    }
    
    public boolean check(char target) {
        for (int i = 0; i < 3; i++) {
            if (b[i][0] == target && b[i][0] == b[i][1] && b[i][1] == b[i][2]) return true;
            if (b[0][i] == target && b[0][i] == b[1][i] && b[1][i] == b[2][i]) return true;
        }
        
        if (b[0][0] == target && b[0][0] == b[1][1] && b[1][1] == b[2][2]) return true;
        if (b[2][0] == target && b[2][0] == b[1][1] && b[1][1] == b[0][2]) return true;
        
        return false;
    }
}