import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        char[] str = Integer.toString(storey).toCharArray();
        int len = str.length;
        
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = str[i] - '0';
        }
        
        for (int i = len - 1; i >= 0; i--) {
            int n = nums[i];
            
            if (n >= 10) {
                if (i > 0) nums[i-1]++;
                else answer++;
            } else if (n < 5) {
                answer += n;
            } else if (n == 5) {
                if (i > 0) {
                    if (nums[i-1] < 5) answer += n;
                    else {
                        answer += 10 - n;
                        nums[i-1]++;
                    }
                } else answer += n;
            } else {
                answer += 10 - n;
                
                if (i > 0) nums[i-1]++;
                else answer++;
            }
        }
        
        return answer;
    }
}