import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (String str : keymap) {
            for (int i = 0; i < str.length(); i++) {
                char curr = str.charAt(i);
                map.put(curr, map.containsKey(curr) ? Math.min(i+1, map.get(curr)) : i+1);
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            String tmp = targets[i];
            int ans = 0;
            for (int j = 0; j < tmp.length(); j++) {
                if (map.containsKey(tmp.charAt(j))) {
                    ans += map.get(tmp.charAt(j));
                } else {
                    ans = -1;
                    break;
                }
            }
            answer[i] = ans;
        }
        
        return answer;
    }
}