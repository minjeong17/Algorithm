import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] inc = new int[24];
        for (int i = 0; i < players.length; i++) {
            int n = players[i] / m;
            int diff = n - inc[i];
            
            if (diff > 0) {
                answer += diff;
                for (int j = i; j < Math.min(i + k, 24); j++) {
                    inc[j] += diff;
                }
            }
        }
        
        return answer;
    }
}