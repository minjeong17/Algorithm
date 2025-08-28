import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Map<Double, Integer> map = new HashMap<>();
        
        Arrays.sort(weights);
        for (double weight : weights) {
            
            // 1:1 1:2 2:3 3:4
            double w1 = weight / 2;
            double w2 = (weight / 3) * 2;
            double w3 = (weight / 4) * 3;
            
            if (map.containsKey(weight)) answer += map.get(weight);
            if (map.containsKey(w1)) answer += map.get(w1);
            if (map.containsKey(w2)) answer += map.get(w2);
            if (map.containsKey(w3)) answer += map.get(w3);
            
            map.put(weight, map.getOrDefault(weight, 0)+1);   
        }
        
        return answer;
    }
}