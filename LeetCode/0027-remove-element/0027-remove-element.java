import java.util.*;

class Solution {
    public int removeElement(int[] nums, int val) {
        int answer = 0;

        int idx = 0;
        for (int n : nums) {
            if (n == val) continue;

            answer++;
            nums[idx++] = n;
        }

        return answer;
    }
}