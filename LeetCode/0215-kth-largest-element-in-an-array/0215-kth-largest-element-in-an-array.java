import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int minN = Integer.MAX_VALUE;
        int maxN = Integer.MIN_VALUE;
        int[] cnt = new int[20001];
        for (int n : nums) {
            cnt[n + 10000]++;

            minN = Math.min(minN, n);
            maxN = Math.max(maxN, n);
        }

        int total = k;
        for (int n = maxN + 10000; n >= minN + 10000; n--) {
            if (total <= cnt[n]) return n - 10000;
            else total -= cnt[n];
        }
        
        return 0;
    }
}