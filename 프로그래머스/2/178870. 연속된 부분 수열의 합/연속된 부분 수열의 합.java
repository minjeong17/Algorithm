import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = sequence.length;
        
        int left = 0;
        int sum = 0;
        for (int right = 0; right < sequence.length; right++) {
            sum += sequence[right];
            
            while (sum > k) {
                sum -= sequence[left];
                left++;
            }
            
            if (sum == k && answer[1] - answer[0] > right - left) {
                answer[0] = left;
                answer[1] = right;
            }
        }
        
        return answer;
    }
}