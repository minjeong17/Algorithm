import java.util.*;

class Solution {
    
    Map<String, PriorityQueue<String>> map;
    List<String> ans;
    
    public String[] solution(String[][] tickets) {
        
        map = new HashMap<>();
        for (String[] t : tickets) {
            if (!map.containsKey(t[0])) {
                map.put(t[0], new PriorityQueue<>());
            } 
            map.get(t[0]).add(t[1]);
        }
        
        ans = new ArrayList<>();
        
        dfs("ICN");
        
        int idx = 0;
        String[] answer = new String[ans.size()];
        for (int i = ans.size()-1; i >= 0; i--) {
            answer[idx++] = ans.get(i);
        }
        
        return answer;
    }
    
    public void dfs(String start) {
        while (map.containsKey(start) && !map.get(start).isEmpty()) {
            String next = map.get(start).poll();
            dfs(next);
        }
        
        ans.add(start);
    }
}