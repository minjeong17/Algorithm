import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int len = players.length;
        String[] answer = new String[len];
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(players[i], i);
        }
        
        for (String name : callings) {
            int idx = map.get(name);
            String prev = players[idx-1];
            
            players[idx-1] = name;
            players[idx] = prev;
            
            map.put(name, idx-1);
            map.put(prev, idx);
        }
        
        return players;
    }
}