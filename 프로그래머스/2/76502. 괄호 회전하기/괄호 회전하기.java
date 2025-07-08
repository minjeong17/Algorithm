import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String newS = s + s;
        
        int len = s.length();
        for (int i = 0; i < len; i++) {
            Stack<Character> stack = new Stack<>();
            
            boolean isOk = true;
            for (int j = i; j < i + len; j++) {
                char curr = newS.charAt(j);
                if (curr == '(' || curr == '{' || curr == '[') {
                    stack.push(curr);
                } else {
                    if (stack.isEmpty()) {
                        isOk = false;
                        break;
                    } else {
                        char p = stack.pop();
                        if (curr == ')') {
                            if (p != '(') {
                                isOk = false;
                                break;
                            }
                        } else if (curr == '}') {
                            if (p != '{') {
                                isOk = false;
                                break;
                            }
                        } else {
                            if (p != '[') {
                                isOk = false;
                                break;
                            }
                        }
                    }
                }
            }
            
            if (isOk && stack.isEmpty()) answer++;
        }
        
        
        
        return answer;
    }
}