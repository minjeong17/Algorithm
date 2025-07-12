import java.util.*;

class Solution {
    List<String> list;
    String[] sel;
    String[] vowel;
    
    public int solution(String word) {
        
        vowel = new String[] {"A", "E", "I", "O", "U"};
        
        list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            sel = new String[i];
            comb(0, 0, i);
        }
        
        Collections.sort(list);

        return list.indexOf(word)+1;
    }
    
    public void comb(int idx, int sidx, int len) {
        if (sidx == len) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(sel[i]);
            }
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < 5; i++) {
            sel[sidx] = vowel[i];
            comb(i+1, sidx+1, len);
        }
    }
}