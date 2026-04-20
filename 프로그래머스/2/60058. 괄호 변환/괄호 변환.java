import java.util.*;

class Solution {
    public String solution(String p) {        
        return split(p);
    }
    
    public String split(String p) {
        if (p.length() == 0) return "";
        
        int cnt1 = 0;
        int cnt2 = 0;
        int idx = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') cnt1++;
            else cnt2++;
            
            if (cnt1 == cnt2) {
                idx = i;
                break;
            }
        }
        
        String u = p.substring(0, idx+1);
        String v = p.substring(idx+1, p.length());
        
        if (check(u.toString())) {
            return u + split(v);
        } else {
            return "(" + split(v) + ")" + reverse(u);
        }
    }
    
    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        
        if (stack.isEmpty()) return true;
        else return false;
    }
    
    public String reverse(String u) {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') res.append(')');
            else res.append('(');
        }
        
        return res.toString();
    }
}
