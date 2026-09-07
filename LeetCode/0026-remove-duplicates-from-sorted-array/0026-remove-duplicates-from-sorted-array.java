import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int n : nums) set.add(n);

        int idx = 0;
        for (int n : set) {
            nums[idx++] = n;
        }

        return set.size();
    }
}