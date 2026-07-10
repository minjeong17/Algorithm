import java.util.*;

class Solution {
    int n, maxAns;
    int[] info, ans;
    int[] lion = new int[11];
    public int[] solution(int n, int[] info) {
        this.info = info;
        this.n = n;
        
        maxAns = Integer.MIN_VALUE;
        ans = new int[11];
        dfs(0, n);
        
        if (maxAns == Integer.MIN_VALUE) return new int[] {-1};
        else return ans;
    }
    
    // idx번째를 선택할지 말지 결정
    public void dfs(int idx, int remain) {
        if (idx == 11) {
            lion[10] += remain;
            checkScore();
            lion[10] -= remain;
            return;
        }
        
        if (remain >= info[idx] + 1) {
            lion[idx] = info[idx] + 1;
            dfs(idx+1, remain-lion[idx]);
            lion[idx] = 0;
        }
        
        dfs(idx+1, remain);
    }
    
    public void checkScore() {
        int lionSc = 0;
        int apeachSc = 0;
        
        for (int i = 0; i < 11; i++) {
            if (lion[i] > 0) lionSc += 10 - i;
            else {
                if (info[i] > 0) apeachSc += 10 - i;
            }
        }
                
        if (lionSc > apeachSc) {
            if (lionSc - apeachSc > maxAns) {
                ans = lion.clone();
                maxAns = lionSc - apeachSc;
            } else if (lionSc - apeachSc == maxAns) {
                boolean flag = false;
                for (int i = 10; i >= 0; i--) {
                    if (lion[i] > ans[i]) {
                        flag = true;
                        break;
                    } else if (lion[i] < ans[i]) break;
                }
                
                if (flag) {
                    ans = lion.clone();
                }
            }
        }
    }
}