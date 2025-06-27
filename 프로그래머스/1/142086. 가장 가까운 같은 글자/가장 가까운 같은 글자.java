import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        Map<Character, Integer> loc = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (loc.containsKey(curr)) {
                answer[i] = i - loc.get(curr);
            } else {
                answer[i] = -1;
            }
            loc.put(curr, i);
        }
        
        return answer;
    }
}