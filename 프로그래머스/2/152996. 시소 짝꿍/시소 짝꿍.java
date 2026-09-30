import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Integer, Long> cnt = new TreeMap<>();
        for (int w : weights) {
            cnt.put(w, cnt.getOrDefault(w, 0L) + 1);
        }
        
        for (int k : cnt.keySet()) {
            long v = cnt.get(k);
            
            answer += v * (v - 1) / 2;
            
            if (cnt.containsKey(k * 2)) answer += v * cnt.get(k * 2);
            if ((k * 3) % 2 == 0 && cnt.containsKey(k * 3 / 2)) answer += v * cnt.get(k * 3 / 2);
            if ((k * 4) % 3 == 0 && cnt.containsKey(k * 4 / 3)) answer += v * cnt.get(k * 4 / 3);
        } 
        
        return answer;
    }
}