import java.util.*;

class Solution {
    
    Map<String, Integer> cnt;
    int[] maxLen = new int[11];
    char[] sel;
        
    public String[] solution(String[] orders, int[] course) {
        
        cnt = new HashMap<>();
        
        for (int c : course) {
            for (String order : orders) {
                sel = new char[c];
                char[] ch = order.toCharArray();
                Arrays.sort(ch);
                comb(0, 0, c, ch);
            }
        }
        
        List<String> list = new ArrayList<>();
        
        for (String str : cnt.keySet()) {
            int strLen = str.length();
            if (maxLen[strLen] == cnt.get(str) && cnt.get(str) >= 2) {
                list.add(str);   
            }
        }
        
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }        
        
        return answer;
    }
    
    public void comb(int idx, int sidx, int c, char[] ch) {
        if (sidx == c) {
            StringBuilder sb = new StringBuilder();
            for (char s : sel) {
                sb.append(s);
            }
            String tmp = sb.toString();
            cnt.put(tmp, cnt.getOrDefault(tmp, 0) + 1);
            maxLen[c] = Math.max(maxLen[c], cnt.get(tmp));
            return;
        }
        
        for (int i = idx; i < ch.length; i++) {
            sel[sidx] = ch[i];
            comb(i+1, sidx+1, c, ch);
        }
    }
}