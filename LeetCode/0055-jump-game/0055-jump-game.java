import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        int maxReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (maxReach < i) return false;

            maxReach = Math.max(maxReach, nums[i] + i);

            if (maxReach >= nums.length - 1) return true;
        }

        return maxReach >= (nums.length - 1);
    }
}