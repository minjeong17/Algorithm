import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        if (n > s) return new int[] {-1};
        
        int[] answer = new int[n];
        int n1 = s / n;
        int n2 = s % n;
        
        Arrays.fill(answer, n1);
        for (int i = 0; i < n2; i++) {
            answer[n - i - 1]++;
        }
        
        return answer;
    }
}