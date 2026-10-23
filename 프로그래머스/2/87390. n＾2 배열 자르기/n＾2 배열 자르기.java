import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        
        int idx = 0;
        for (long i = left; i <= right; i++) {
            int a = (int) (i / n);
            int b = (int) (i % n);
            
            if (a + 1 > b) {
                answer[idx++] = a + 1;
            } else {
                answer[idx++] = b + 1;
            }
        }
        
        return answer;
    }
}