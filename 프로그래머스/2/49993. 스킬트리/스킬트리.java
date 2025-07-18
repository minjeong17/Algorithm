import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Map<Character, Integer> order = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            order.put(skill.charAt(i), i);
        }
        
        for (String sk : skill_trees) {
            boolean isOk = true;
            int cnt = 0;
            for (int i = 0; i < sk.length(); i++) {
                if (order.containsKey(sk.charAt(i))) {
                    if (order.get(sk.charAt(i)) == cnt) cnt++;
                    else {
                        isOk = false;
                        break;
                    }
                }
            }
            if (isOk) answer++;
        }
        
        return answer;
    }
}