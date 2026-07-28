import java.util.*;

class Solution {
    int[][] dungeons;
    int len, answer;
    boolean flag;
    boolean[] visited;
    int[] sel;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        
        answer = 0;
        
        len = dungeons.length;
        sel = new int[len];
        visited = new boolean[len];
        flag = false;
        perm(0, k);
        
        return answer;
    }
    
    public void perm(int idx, int k) {
        if (flag) return;
        
        if (idx == len) {
            check(sel, k);
            if (answer == len) flag = true;
            return;
        }
        
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sel[idx] = i;
                perm(idx + 1, k);
                visited[i] = false;
            }
        }
    }
    
    public void check(int[] sel, int k) {
        int cnt = 0;
        for (int s : sel) {
            if (k >= dungeons[s][0]) {
                cnt++;
                k -= dungeons[s][1];
            } else break;
        }
        
        answer = Math.max(answer, cnt);
    } 
}