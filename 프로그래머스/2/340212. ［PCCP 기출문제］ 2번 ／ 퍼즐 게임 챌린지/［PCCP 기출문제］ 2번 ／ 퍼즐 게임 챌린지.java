import java.util.*;

class Solution {
    int[] diffs, times;
    long limit;
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        int left = 1;
        int right = diffs[0];
        for (int d : diffs) right = Math.max(d, right);
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right;
    }
    
    public boolean check(int level) {
        long total = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                total += times[i];
            } else {
                total += (long) (diffs[i] - level) * (times[i] + times[i-1]) + times[i];
            }
            
            if (total > limit) return false;
        }
        
        return true;
    }
}