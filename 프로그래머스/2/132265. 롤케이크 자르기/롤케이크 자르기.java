import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> type1 = new HashMap<>();
        Map<Integer, Integer> type2 = new HashMap<>();
        
        for (int i = 0; i < topping.length; i++) {
            type2.put(topping[i], type2.getOrDefault(topping[i], 0) + 1);
        }
        
        int idx = 0;
        while (type2.size() > 0) {
            int t = topping[idx];
            
            type1.put(t, type1.getOrDefault(t, 0) + 1);
            if (type2.get(t) == 1) type2.remove(t);
            else type2.put(t, type2.get(t) - 1);
            
            if (type1.size() == type2.size()) answer++;
            idx++;
        }
        
        return answer;
    }
}