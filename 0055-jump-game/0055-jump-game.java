import java.util.*;

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        List<Integer> zeroIdx = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) zeroIdx.add(i);
        }

        if (zeroIdx.size() == 0) return true;

        for (int idx : zeroIdx) {
            boolean flag = false;
            for (int i = 0; i < idx; i++) {
                if (nums[i] > idx - i) {
                    flag = true;
                    break;
                }
            }

            if (!flag) return false;
        }

        return true;
    }
}