import java.util.*;

class Solution {
    public int minMoves(int[] nums) {
        int maxN = nums[0];
        for (int n : nums) maxN = Math.max(maxN, n);

        int answer = 0;
        for (int n : nums) answer += maxN - n;

        return answer;
    }
}