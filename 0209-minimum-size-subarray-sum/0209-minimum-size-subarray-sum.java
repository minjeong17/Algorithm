import java.util.*;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;

        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            if (sum >= target) {
                while (sum >= target) {
                    sum -= nums[left];
                    left++;
                }

                answer = Math.min(answer, right - left + 2);
            }

        }

        return answer == Integer.MAX_VALUE ? 0 : answer;    
    }
}