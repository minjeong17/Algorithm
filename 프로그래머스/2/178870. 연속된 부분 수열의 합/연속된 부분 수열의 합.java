import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length-1};
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        while (left <= right) {
            if (sum == k) {
                if (right - left < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                } else if (right - left == answer[1] - answer[0]) {
                    if (left < answer[0]) {
                        answer[0] = left;
                        answer[1] = right;
                    }
                }
                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                if (right + 1 == sequence.length) break;
                sum += sequence[++right];
            } else {
                sum -= sequence[left++];
                if (left == sequence.length) break;
            };
        }
        
        return answer;
    }
}