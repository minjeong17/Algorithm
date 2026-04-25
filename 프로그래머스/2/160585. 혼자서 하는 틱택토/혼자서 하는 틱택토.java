class Solution {
    public int solution(String[] board) {
        // 1. O 개수 == X 개수 || O 개수 = X 개수 + 1
        int cntO = 0;
        int cntX = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') cntO++;
                else if (board[i].charAt(j) == 'X') cntX++;
            }
        }
        
        if (cntO != cntX && cntO != cntX + 1) return 0;
        
        // 2. O / X 가 동시에 완성되면 안 됨
        // 3. O 완성 -> O 개수 = X 개수 + 1
        // 4. X 완성 -> O 개수 == X 개수
        boolean winO = checkWin(board, 'O');
        boolean winX = checkWin(board, 'X');
        
        if (winO && winX) return 0;
        if (winO) {
            if (cntO == cntX + 1) return 1;
            else return 0;
        }
        if (winX) {
            if (cntO == cntX) return 1;
            else return 0;
        }
        
        return 1;
    }
    
    public boolean checkWin(String[] board, char w) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == w && board[i].charAt(1) == w && board[i].charAt(2) == w) return true;
        }
        
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == w && board[1].charAt(j) == w && board[2].charAt(j) == w) return true;
        }
        
        if (board[0].charAt(0) == w && board[1].charAt(1) == w && board[2].charAt(2) == w) return true;
        if (board[2].charAt(0) == w && board[1].charAt(1) == w && board[0].charAt(2) == w) return true;
        
        return false;
    }
}