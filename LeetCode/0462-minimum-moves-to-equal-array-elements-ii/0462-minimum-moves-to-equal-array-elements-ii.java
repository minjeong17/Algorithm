import java.util.*;

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int medN = nums[nums.length / 2];

        int answer = 0;
        for (int n : nums) answer += Math.abs(n - medN);

        return answer;
    }
}