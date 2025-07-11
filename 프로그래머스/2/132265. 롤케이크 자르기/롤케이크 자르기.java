import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> cntTopping = new HashMap<>();
        for (int t : topping) cntTopping.put(t, cntTopping.getOrDefault(t, 0) + 1);
        
        Set<Integer> hs = new HashSet<>();
        for (int t : topping) {
            hs.add(t);
            if (cntTopping.get(t) == 1) cntTopping.remove(t);
            else {
                cntTopping.put(t, cntTopping.get(t)-1);
            }
            
            if (hs.size() == cntTopping.size()) answer++;
        }
        
        return answer;
    }
}