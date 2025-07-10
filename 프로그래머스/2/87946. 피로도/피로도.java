import java.util.*;

class Solution {
    
    int[][] dungns;
    int[][] sel;
    boolean[] visited;
    int limit;
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        dungns = dungeons;
        
        for (int i = dungeons.length; i >= 1; i--) {
            sel = new int[i][2];
            visited = new boolean[dungns.length];
            limit = k;
            perm(0, i, k);
            if (answer != 0) break;
        }
        
        return answer;
    }
    
    boolean flag = false;
    
    public void perm (int idx, int len, int k) {
        
        if (flag) return;
        
        if (idx == len) {
            if (find(sel, k)) {
                flag = true;
                answer = len;
            }
            return;
        }
        
        for (int i = 0; i < dungns.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sel[idx] = dungns[i];
                perm(idx+1, len, k);
                visited[i] = false;
            }
        }
    }
    
    public boolean find(int[][] sel, int limit) {
        for (int[] dun : sel) {
            if (limit < 0) return false;
            if (dun[0] > limit) return false;
            else {
                limit -= dun[1];
            }
        }
        return true;
    }
}