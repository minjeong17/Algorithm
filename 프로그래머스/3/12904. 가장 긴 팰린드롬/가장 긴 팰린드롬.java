import java.util.*;

class Solution {
    int answer = 1;
    public int solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            check(s, i - 1, i + 1);
            check(s, i, i + 1);
        }
        
        return answer;
    }
    
    public void check(String s, int l, int r) {
        int left = l;
        int right = r;
        while (left >= 0 && right < s.length()) {                
            if (s.charAt(left) == s.charAt(right)) {
                answer = Math.max(answer, right - left + 1);
                left--;
                right++;
            } else break;
        }
    }
}