import java.util.*;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int answer = 0;
        Map<Integer, Integer> cnt = new HashMap<>();

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            cnt.put(nums[right], cnt.getOrDefault(nums[right], 0) + 1);

            if (cnt.get(nums[right]) <= k) {
                answer = Math.max(answer, right - left + 1);
            } else {
                while (cnt.get(nums[right]) > k && left <= right) {
                    if (cnt.get(nums[left]) == 1) cnt.remove(nums[left]); 
                    else cnt.put(nums[left], cnt.get(nums[left]) - 1);

                    left++;
                }
            }

            right++;
        }

        return answer;
    }
}