import java.util.*;

class Solution {
    Map<String, List<String>> map;
    public int solution(String begin, String target, String[] words) {
        
        map = new HashMap<>();
        for (String word : words) {
            if (check(begin, word)) {
                map.computeIfAbsent(begin, key -> new ArrayList<>()).add(word);
                map.computeIfAbsent(word, key -> new ArrayList<>()).add(begin);
            }
        }
        for (int i = 0; i < words.length; i++) {
            String w1 = words[i];
            for (int j = i+1; j < words.length; j++) {
                String w2 = words[j];
                if (check(w1, w2)) {
                    map.computeIfAbsent(w1, key -> new ArrayList<>()).add(w2);
                    map.computeIfAbsent(w2, key -> new ArrayList<>()).add(w1);
                }
            }
        }
        System.out.println(map);
        if (!map.containsKey(target)) return 0;
        return bfs(begin, target);
    }
    
    public boolean check(String w1, String w2) {
        int diffCnt = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) diffCnt++;
            
            if (diffCnt > 1) return false;
        }
        
        if (diffCnt == 1) return true;
        else return false;
    }
    
    public int bfs(String begin, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        q.add(begin);
        visited.add(begin);
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (curr.equals(target)) return cnt;
                
                for (String w : map.get(curr)) {
                    if (visited.contains(w)) continue;
                    visited.add(w);
                    q.add(w);
                }
            }
            
            cnt++;
        }
        
        return 0;
    }
}