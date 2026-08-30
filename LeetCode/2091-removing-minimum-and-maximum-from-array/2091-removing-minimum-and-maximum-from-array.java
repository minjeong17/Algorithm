import java.util.*;

class Solution {
    public int minimumDeletions(int[] nums) {
        int len = nums.length;

        int maxNum = Integer.MIN_VALUE;
        int maxIdx = -1;
        int minNum = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < len; i++) {
            if (maxNum < nums[i]) {
                maxNum = nums[i];
                maxIdx = i;
            }

            if (minNum > nums[i]) {
                minNum = nums[i];
                minIdx = i;
            }
        }

        int front = Math.max(maxIdx, minIdx) + 1;
        int back = Math.max(len - maxIdx, len - minIdx);

        int n1 = Math.min(maxIdx, minIdx);
        int n2 = Math.max(maxIdx, minIdx);

        return Math.min(Math.min(front, back), n1 + (len - n2) + 1);
    }
}