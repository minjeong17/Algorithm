import java.util.*;

class Solution {
    int[] answer, info;
    int diff;
    public int[] solution(int n, int[] info) {
        this.info = info;
        
        answer = new int[11];
        diff = Integer.MIN_VALUE;
        
        int apeach = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] > 0) apeach += 10 - i;
        }
        
        dfs(0, n, apeach, new int[11], 0);
        
        return diff == Integer.MIN_VALUE ? new int[] {-1} : answer;
    }
    
    public void dfs(int lion, int left, int apeach, int[] ans, int start) {        
        if (start == 10) {
            ans[10] = left;
            
            if (lion <= apeach) return;
            
            if (diff < lion - apeach) {
                diff = Math.max(diff, lion - apeach);
                for (int i = 0; i < 11; i++) answer[i] = ans[i];
            } else if (diff == lion - apeach) {
                boolean change = false;
                for (int i = 10; i >= 0; i--) {
                    if (answer[i] < ans[i]) {
                        change = true;
                        break;
                    } else if (answer[i] > ans[i]) break;
                }
                
                if (change) {
                    for (int i = 0; i < 11; i++) answer[i] = ans[i];
                }
            }
            return;
        }
        
        // 쏘기
        if (info[start] + 1 <= left) {
            ans[start] = info[start] + 1;
            if (info[start] > 0) dfs(lion + 10 - start, left - ans[start], apeach - (10 - start), ans, start+1);
            else dfs(lion + 10 - start, left - ans[start], apeach, ans, start+1);
            ans[start] = 0;
        }
        
        // 안 쏘기
        dfs(lion, left, apeach, ans, start+1);
    }
}