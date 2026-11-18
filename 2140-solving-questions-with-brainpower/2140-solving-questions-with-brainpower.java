import java.util.*;

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] scores = new long[n+1];
        for (int i = n - 1; i >= 0; i--) {
            int[] curr = questions[i];
            
            if (curr[1] + i + 1 < n) {
                scores[i] = Math.max(scores[curr[1] + i + 1] + curr[0], scores[i + 1]);
            } else {
                scores[i] = Math.max(curr[0], scores[i + 1]);
            }
        }

        return scores[0];
    }
}