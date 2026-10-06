import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        int answer = 0;

        Map<Integer, Integer> sumIdx = new HashMap<>();
        sumIdx.put(0, -1);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : nums[i];

            if (sumIdx.containsKey(sum)) answer = Math.max(i - sumIdx.get(sum), answer);
            else sumIdx.put(sum, i);
        }

        return answer;
    }
}