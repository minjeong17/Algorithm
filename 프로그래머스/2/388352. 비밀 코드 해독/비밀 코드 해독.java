import java.util.*;

class Solution {
    int n, answer;
    int[] sel, ans;
    int[][] q;
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        
        answer = 0;
        
        sel = new int[5];
        comb(1, 0);
        
        return answer;
    }
    
    public void comb(int idx, int sidx) {
        if (sidx == 5) {
            check(sel);
            return;
        }
        
        for (int i = idx; i <= n; i++) {
            sel[sidx] = i;
            comb(i+1, sidx+1);
        }
    }
    
    public void check(int[] sel) {
        Set<Integer> set = new HashSet<>();
        for (int n : sel) set.add(n);
        
        boolean flag = true;
        for (int i = 0; i < q.length; i++) {
            int[] qq = q[i];
            
            int cnt = 0;
            for (int n : qq) {
                if (set.contains(n)) cnt++;
            }
            
            if (cnt != ans[i]) {
                flag = false;
                break;
            }
        }
        
        if (flag) answer++;
    }
}