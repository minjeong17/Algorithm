import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int answer = -1;

        int[] cnt = new int[51];
        for (int n : nums) cnt[n]++;

        if (k == 1) {
            for (int i = 50; i >= 0; i--) {
                if (cnt[i] == 1) {
                    answer = i;
                    break;
                }
            }
        } else if (k == nums.length) {
            for (int i = 50; i >= 0; i--) {
                if (cnt[i] > 0) {
                    answer = i;
                    break;
                }
            }
        } else {
            if (cnt[nums[0]] == 1) answer = nums[0];
            if (cnt[nums[nums.length - 1]] == 1) answer = Math.max(answer, nums[nums.length - 1]);
        }

        return answer;
    }
}