import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String newS = s + s;
        
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (check(newS.substring(i, i + len))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return false;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
            }
        }
        
        if (stack.isEmpty()) return true;
        else return false;
    }
}