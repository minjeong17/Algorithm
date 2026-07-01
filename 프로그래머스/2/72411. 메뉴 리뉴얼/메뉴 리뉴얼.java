import java.util.*;

class Solution {
    Map<String, Integer> map;
    Map<Integer, Integer> cntMap;
    Character[] sel;
    char[] order;
    public String[] solution(String[] orders, int[] course) {
        
        map = new HashMap<>();
        cntMap = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {
            order = orders[i].toCharArray();
            Arrays.sort(order);
            for (int c : course) {
                sel = new Character[c];
                if (!cntMap.containsKey(c)) cntMap.put(c, 0);
                comb(0, 0, c);
            }
        }
        
        List<String> ansList = new ArrayList<>();
        for (String cand : map.keySet()) {
            int size = map.get(cand);
            if (size >= 2 && size == cntMap.get(cand.length())) ansList.add(cand);
        }
        
        String[] answer = new String[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public void comb (int idx, int sidx, int c) {
        if (sidx == sel.length) {
            StringBuilder sb = new StringBuilder();
            for (char s : sel) sb.append(s);
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            cntMap.put(c, Math.max(cntMap.get(c), map.get(sb.toString())));
            return;
        }
        
        for (int i = idx; i < order.length; i++) {
            sel[sidx] = order[i];
            comb(i+1, sidx+1, c);
        }
    }
}