import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> nums = new ArrayList<>();
        long[] fact = new long[n+1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = i * fact[i-1];
            nums.add(i);
        }
        
        k--;
        for (int i = 0; i < n; i++) {
            int idx = (int) (k / fact[n - i - 1]);
            answer[i] = nums.get(idx);
            nums.remove(idx);
            
            k %= fact[n - i - 1];
        }
        
        return answer;
    }
}