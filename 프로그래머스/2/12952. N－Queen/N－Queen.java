import java.util.*;

class Solution {
    public int[] queen;
    public int answer;
    public int solution(int n) {
        answer = 0;
        
        queen = new int[n];
        dfs(0, n);  // 0행부터 놓기 시작
        
        return answer;
    }
    
    public void dfs(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }
        
        for (int j = 0; j < n; j++) {
            if (check(row, j)) {
                queen[row] = j;
                dfs(row+1, n);
            }
        }
    }
    
    public boolean check(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queen[i] == col) return false;
            
            if (Math.abs(row - i) == Math.abs(col - queen[i])) return false;
        }
        
        return true;
    }
}