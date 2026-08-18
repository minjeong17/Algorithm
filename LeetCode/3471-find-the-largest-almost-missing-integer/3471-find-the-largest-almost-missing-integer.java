import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int answer = -1;

        if (k == 1) {
            Map<Integer, Integer> cntMap = new TreeMap<>((o1, o2) -> o2 - o1);
            for (int n : nums) cntMap.put(n, cntMap.getOrDefault(n, 0) + 1);

            for (int n : cntMap.keySet()) {
                if (cntMap.get(n) == 1) {
                    answer = n;
                    break;
                }
            }
        } else if (k == nums.length) {
            if (k == 2) answer = Math.max(nums[0], nums[1]);
            else {
                Arrays.sort(nums);
                answer = nums[nums.length - 1];
            }
        } else {
            if (nums[0] != nums[nums.length - 1]) {
                int cand1 = nums[0];
                int cand2 = nums[nums.length - 1];
                for (int i = 1; i < nums.length - 1; i++) {
                    if (nums[i] == cand1) cand1 = -1;
                    if (nums[i] == cand2) cand2 = -1;

                    if (cand1 == -1 && cand2 == -1) break;
                }

                answer = Math.max(cand1, cand2);
            }
        }

        return answer;
    }
}