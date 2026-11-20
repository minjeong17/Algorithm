import java.util.*;

class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int n : nums) sum += n;

        int target = sum - x;
        if (target < 0) return -1;
        if (target == 0) return nums.length;
        
        int answer = 0;
        int left = 0;
        int tmp = 0;
        for (int right = 0; right < nums.length; right++) {
            tmp += nums[right];
            
            while (tmp > target) {
                tmp -= nums[left++];
            }

            if (tmp == target) {
                answer = Math.max(answer, right - left + 1);
            }
        }

        return answer == 0 ? -1 : nums.length - answer;
    }
}