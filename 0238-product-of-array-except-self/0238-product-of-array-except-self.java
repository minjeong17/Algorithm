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
            Arrays.fill(answer, 1);
            int prefix = nums[0];
            for (int i = 1; i < nums.length; i++) {
                answer[i] = prefix;
                prefix *= nums[i];
            }
            
            int suffix = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                answer[i] *= suffix;
                suffix *= nums[i];
            }
        } 

        return answer;
    }
}