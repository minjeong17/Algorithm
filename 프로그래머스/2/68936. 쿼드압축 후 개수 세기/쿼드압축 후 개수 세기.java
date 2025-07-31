import java.util.*;

class Solution {
    
    int cnt0 = 0;
    int cnt1 = 0;
    
    public int[] solution(int[][] arr) {
        
        int len = arr.length;
        dfs(0, 0, 0, 0, len, arr);
     
        return new int[] {cnt0, cnt1};
    }
    
    public void dfs(int r, int c, int c0, int c1, int len, int[][] arr) {
        
        if (len == 0) return;
                
        for (int i = r; i < r+len; i++) {
            for (int j = c; j < c+len; j++) {
                if (arr[i][j] == 0) c0++;
                else c1++;
            }
        }
        
        if (c0 != 0 && c1 != 0) {
            int nextLen = len / 2;
            
            dfs(r, c, 0, 0, nextLen, arr);
            dfs(r, c+nextLen, 0, 0, nextLen, arr);
            dfs(r+nextLen, c, 0, 0, nextLen, arr);
            dfs(r+nextLen, c+nextLen, 0, 0, nextLen, arr);
        } else {
            if (c0 == 0) cnt1++;
            else cnt0++;
        }
    }
}