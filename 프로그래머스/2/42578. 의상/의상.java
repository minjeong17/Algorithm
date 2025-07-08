import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> cnt = new HashMap<>();
        for (String[] c : clothes) {
            cnt.put(c[1], cnt.getOrDefault(c[1], 0) + 1);
        }
        
        for (String s : cnt.keySet()) {
            answer *= (cnt.get(s) + 1);
        }
        
        return answer - 1;
    }
}