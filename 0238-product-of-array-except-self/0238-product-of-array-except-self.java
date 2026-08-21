import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        List<int[]> zeros = new ArrayList<>();
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros.add(new int[] {i, 0});
            else prod *= nums[i];
        }

        if (zeros.size() >= 2) return answer;
        else if (zeros.size() == 1) {
            answer[zeros.get(0)[0]] = prod;
        } else {
            for (int i = 0; i < nums.length; i++) {
                answer[i] = prod / nums[i];
            }
        }

        return answer;
    }
}