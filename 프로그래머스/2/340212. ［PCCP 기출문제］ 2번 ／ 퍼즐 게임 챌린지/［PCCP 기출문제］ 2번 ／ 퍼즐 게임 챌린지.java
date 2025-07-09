// import java.util.*;

class Solution {
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        
        int left = 1;
        int right = 100000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (calTime(diffs, times, mid, limit)) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean calTime(int[] diffs, int[] times, int lv, long limit) {
        long total = times[0];
        
        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= lv) total += times[i];
            else {
                total += ((diffs[i] - lv) * ((long) (times[i] + times[i-1]))  + times[i]);
            }
        }
        
        if (total <= limit) return true;
        else return false;
        
    }
}