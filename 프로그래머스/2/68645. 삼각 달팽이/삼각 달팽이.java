import java.util.*;

class Solution {
    public int[] solution(int n) {
        int max = n*(n+1)/2;
        int[] answer = new int[max];
        
        int[][] tmp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(tmp[i], -1);
        }
        
        int num = 1;
        int r = -1; int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    r++;
                } else if (i % 3 == 1) {
                    c++;
                } else {
                    r--;
                    c--;
                }  
                tmp[r][c] = num++;
            }
        }
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = tmp[i][j];
            }
        }
        
        return answer;
    }
}