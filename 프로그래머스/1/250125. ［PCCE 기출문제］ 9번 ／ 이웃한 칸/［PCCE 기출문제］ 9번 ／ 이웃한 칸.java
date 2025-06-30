class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        for (int d = 0; d < 4; d++) {
            int nr = h + dr[d];
            int nc = w + dc[d];
            
            if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) continue;
            
            if (board[h][w].equals(board[nr][nc])) answer++;
        }
        return answer;
    }
}