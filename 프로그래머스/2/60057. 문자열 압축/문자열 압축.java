import java.util.*;

class Solution {
    
    int len;
    
    public int solution(String s) {
        
        len = s.length();
        for (int i = 1; i <= s.length(); i++) {
            int tmp = chk(i, s);
            
            len = Math.min(len, tmp);
        }
        
        return len;
    }
    
    public int chk (int len, String s) {
        StringBuilder sb = new StringBuilder();
        
        String prev = s.substring(0, len);
        int cnt = 1;
        int lastIdx = 0;
        for (int i = len; i+len <= s.length(); i+=len) {
            String curr = s.substring(i, i+len);
            if (prev.equals(curr)) {
                cnt++;
            } else {
                if (cnt > 1) sb.append(cnt);
                sb.append(prev);
                prev = curr;
                cnt = 1;
            }
            lastIdx = i;
        }
        
        if (cnt > 1) sb.append(cnt);
        sb.append(prev);
        
        if (lastIdx+len < s.length()) {
            sb.append(s.substring(lastIdx+len));
        }
        
        return sb.length();
    }
}