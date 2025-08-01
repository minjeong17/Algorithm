class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        int len = board.length;
        
        int[][] tmpB = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] == 1) {
                    tmpB[i][j] = 1;
                    for (int d = 0; d < 8; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        
                        if (nr < 0 || nr >= len || nc < 0 || nc >= len) continue;
                        
                        tmpB[nr][nc] = 1;
                    }
                }
            }
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (tmpB[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
}