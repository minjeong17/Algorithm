import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.add(c);
            else {
                if (stack.isEmpty()) return false;
                
                char t = stack.pop();
                if (c == ')' && t != '(') return false;
                if (c == '}' && t != '{') return false;
                if (c == ']' && t != '[') return false;
            }
        }

        return stack.isEmpty() ? true : false;        
    }
}