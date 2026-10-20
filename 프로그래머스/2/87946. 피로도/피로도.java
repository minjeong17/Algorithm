import java.util.*;

class Solution {
    int n, k, answer;
    int[] sel;
    boolean[] visited;
    int[][] dungeons;
    public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        
        answer = 0;
        n = dungeons.length;
        
        sel = new int[n];
        visited = new boolean[n];
        perm(0);
        
        return answer;
    }
    
    public void perm(int idx) {
        if (idx == n) {
            int tired = k;
            int cnt = 0;
            for (int s : sel) {
                if (dungeons[s][0] <= tired) {
                    tired -= dungeons[s][1];
                    cnt++;
                } else break;
            }
            
            answer = Math.max(answer, cnt);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sel[idx] = i;
                perm(idx + 1);
                visited[i] = false;
            }
        }
    }
}