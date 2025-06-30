import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        boolean[] isPrime = new boolean[3001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;
        for (int i = 2; i < Math.sqrt(3001); i++) {
            int idx = 2;
            while (i*idx <= 3000) {
                isPrime[i*idx] = false;
                idx++;
            }        
        }
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (isPrime[nums[i] + nums[j] + nums[k]]) answer++;
                }
            }
        }
        
        
        return answer;
    }
}