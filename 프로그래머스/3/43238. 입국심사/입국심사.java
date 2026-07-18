import java.util.*;

class Solution {
    int n;
    int[] times;
    public long solution(int n, int[] times) {
        this.n = n;
        this.times = times;
                
        long minT = Long.MAX_VALUE;
        for (int t : times) minT = Math.min(minT, t);
        
        long left = 0;
        long right = minT * n;
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (check(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public boolean check(long mid) {
        long sum = 0;
        for (int t : times) {
            sum += mid / t;
        }
        
        if (sum >= n) return true;
        else return false;
    }
}