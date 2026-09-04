import java.util.*;

class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int answer = -1;

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for (int n : nums) minPQ.add(n);

        for (int i = 0; i < nums.length; i++) {
            maxPQ.add(nums[i]);

            int v = maxPQ.peek() - minPQ.peek();
            if (v <= k) {
                answer = i;
                break;
            }

            minPQ.remove(Integer.valueOf(nums[i]));
        }
        

        return answer;
    }
}