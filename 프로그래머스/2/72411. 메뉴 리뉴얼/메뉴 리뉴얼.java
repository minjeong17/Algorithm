import java.util.*;

class Solution {
    int[] maxCnt;
    char[] sel;
    Map<String, Integer> orderCnt;
    public String[] solution(String[] orders, int[] course) {        
        orderCnt = new TreeMap<>(); 
        
        maxCnt = new int[11];
        for (String order : orders) {
            char[] o = order.toCharArray();
            Arrays.sort(o);
            
            for (int c : course) {
                sel = new char[c];
                comb(0, 0, o, c);    
            }
        }
        System.out.println(orderCnt);
        
        List<String> ans = new ArrayList<>();
        for (String s : orderCnt.keySet()) {
            if (orderCnt.get(s) >= 2 && maxCnt[s.length()] == orderCnt.get(s)) ans.add(s);
        }
        
        String[] answer = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer; 
    }
    
    public void comb(int idx, int sidx, char[] o, int c) {
        if (sidx == c) {
            String str = new String(sel);
            orderCnt.put(str, orderCnt.getOrDefault(str, 0) + 1);
            maxCnt[c] = Math.max(maxCnt[c], orderCnt.get(str));
            return;
        }
        
        for (int i = idx; i < o.length; i++) {
            sel[sidx] = o[i];
            comb(i + 1, sidx + 1, o, c);
        }
    }
}