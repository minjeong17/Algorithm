import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> kind = new HashMap<>();
        for (String[] c : clothes) {
            kind.put(c[1], kind.getOrDefault(c[1], 0) + 1);
        }
        
        for (String k : kind.keySet()) {
            answer *= kind.get(k) + 1;
        }
        
        return answer-1;
    }
}