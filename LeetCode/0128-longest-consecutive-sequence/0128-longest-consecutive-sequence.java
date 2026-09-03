import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        int answer = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int curr = n;
                while (set.contains(curr)) {
                    curr++;
                }

                answer = Math.max(answer, curr - n);
            }
        }

        return answer;
    }
}