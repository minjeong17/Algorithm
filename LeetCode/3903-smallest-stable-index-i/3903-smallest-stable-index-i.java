import java.util.*;

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int answer = -1;

        int[] minV = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minV[i] = min;
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);

            if (max - minV[i] <= k) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}