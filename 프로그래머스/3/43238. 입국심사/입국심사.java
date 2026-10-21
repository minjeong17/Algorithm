import java.util.*;

class Solution {
    int n;
    int[] times;
    public long solution(int n, int[] times) {
        this.n = n;
        this.times = times;
        
        long minT = Integer.MAX_VALUE;
        for (int t : times) minT = Math.min(minT, t);
        
        long left = 1L;
        long right = minT * n;
        while (left < right) {
            long mid = (left + right) / 2;
            
            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return right;
    }
    
    public boolean check(long time) {
        long cnt = 0;
        
        for (int t : times) {
            cnt += time / t;
        }
        
        if (cnt >= n) return true;
        else return false;
    }
}