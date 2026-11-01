import java.util.*;

class Solution {
    public int minMoves(int[] nums) {
        int minN = nums[0];
        for (int n : nums) minN = Math.min(minN, n);

        int answer = 0;
        for (int n : nums) answer += n - minN;

        return answer;
    }
}