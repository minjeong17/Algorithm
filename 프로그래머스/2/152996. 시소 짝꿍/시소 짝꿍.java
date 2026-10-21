import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        Map<Integer, Integer> cnt = new TreeMap<>();
        for (int w : weights) {
            cnt.put(w, cnt.getOrDefault(w, 0) + 1);
        }
        
        for (int w : cnt.keySet()) {
            long v = cnt.get(w);
            
            answer += v * (v - 1) / 2;
            
            if ((w * 3) % 2 == 0 && cnt.containsKey(w * 3 / 2)) {
                int t = cnt.get(w * 3 / 2);
                answer += v * t;
            }
            
            if (cnt.containsKey(w * 2)) {
                int t = cnt.get(w * 2);
                answer += v * t;
            } 
            
            if ((w * 4) % 3 == 0 && cnt.containsKey(w * 4 / 3)) {
                int t = cnt.get(w * 4 / 3);
                answer += v * t;
            }
        }
        
        return answer;
    }
}