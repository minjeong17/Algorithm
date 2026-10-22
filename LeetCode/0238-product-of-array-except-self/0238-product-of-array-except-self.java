import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer, 1);

        int mul = 1;
        for (int i = 1; i < nums.length; i++) {
            mul *= nums[i-1];

            answer[i] *= mul;
        }

        mul = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            mul *= nums[i+1];
            answer[i] *= mul;
        }

        return answer;
    }
}