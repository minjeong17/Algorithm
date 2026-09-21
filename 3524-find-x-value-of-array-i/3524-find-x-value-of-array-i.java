import java.util.*;

class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] answer = new long[k];
        long[] prev = new long[k];

        for (int n : nums) {
            long[] curr = new long[k];

            int r = n % k;

            curr[r]++;

            for (int i = 0; i < k; i++) {
                int nr = (i * r) % k;
                curr[nr] += prev[i];
            }

            for (int i = 0; i < k; i++) {
                answer[i] += curr[i];
            }

            prev = curr;
        }

        return answer;
    }
}