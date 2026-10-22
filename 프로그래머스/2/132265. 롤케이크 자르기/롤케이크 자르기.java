import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> cs = new HashMap<>();
        for (int t : topping) cs.put(t, cs.getOrDefault(t, 0) + 1);
        
        Set<Integer> brother = new HashSet<>();
        for (int t : topping) {
            brother.add(t);
            
            if (cs.get(t) == 1) cs.remove(t);
            else cs.put(t, cs.get(t) - 1);
            
            if (cs.size() == brother.size()) answer++;
        }
        
        return answer;
    }
}