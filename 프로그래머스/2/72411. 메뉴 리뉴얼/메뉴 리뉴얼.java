import java.util.*;

class Solution {
    int n;
    char[] tmp, sel;
    Map<String, Integer> types;
    StringBuilder sb = new StringBuilder();
    public String[] solution(String[] orders, int[] course) {
        
        Set<String> set = new HashSet<>();
        
        for (int c : course) {
            types = new HashMap<>();
            List<String> t = new ArrayList<>();
            for (String order : orders) {
                tmp = order.toCharArray();
                Arrays.sort(tmp);

                n = tmp.length;
                
                if (c > n) continue;

                sel = new char[c];
                comb(0, 0, c);
            }
            
            int maxCnt = Integer.MIN_VALUE;
            for (String k : types.keySet()) {
                int v = types.get(k);
                if (v >= 2) {
                    if (maxCnt == v) t.add(k);
                    else if (maxCnt < v) {
                        t = new ArrayList<>();
                        t.add(k);
                        maxCnt = v;
                    }
                }
            }   
            
            for (int i = 0; i < t.size(); i++) set.add(t.get(i));
            
        }
        
        
        
        String[] answer = new String[set.size()];
        int idx = 0;
        for (String str : set) answer[idx++] = str;
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public void comb(int idx, int sidx, int c) {
        if (sidx == c) {
            for (char ch : sel) sb.append(ch);
            types.put(sb.toString(), types.getOrDefault(sb.toString(), 0) + 1);
            sb.setLength(0);
            return;
        }
        
        for (int i = idx; i < n; i++) {
            sel[sidx] = tmp[i];
            comb(i + 1, sidx + 1, c);
        }
    }
}