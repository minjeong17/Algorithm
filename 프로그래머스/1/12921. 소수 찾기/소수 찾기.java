import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] isPrime = new boolean[1000000+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;
        for (int i = 2; i < Math.sqrt(1000000+1); i++) {
            int idx = 2;
            while (i*idx <= 1000000) {
                isPrime[i*idx] = false;
                idx++;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (isPrime[i]) answer++;
        }
        
        return answer;
    }
}