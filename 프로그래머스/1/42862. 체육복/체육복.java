import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        boolean[] isLost = new boolean[n+1];
        for (int l : lost) {
            isLost[l] = true;
        }
        
        Arrays.sort(reserve);
        
        for (int i = 0; i < reserve.length; i++) {
            int r = reserve[i];
            
            if (isLost[r]) {
                isLost[r] = false;
                continue;
            }
            
            if (r-1 > 0 && isLost[r-1]) {
                isLost[r-1] = false;
            } else if (r+1 <= n && isLost[r+1]) {
                if (i+1 < reserve.length && reserve[i+1] == r+1) continue;
                else isLost[r+1] = false;
            }
        }
        System.out.println(Arrays.toString(isLost));
        
        for (int i = 1; i <= n; i++) {
            if (!isLost[i]) answer++;
        }
        
        return answer; 
    }
}