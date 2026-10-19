import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        int curr = 1;
        for (int o : order) {
            if (curr < o) {
                while (curr < o) {
                    stack.push(curr);
                    curr++;
                }
                
                if (curr == o) {
                    answer++;
                    curr++;
                }
            } else if (curr == o) {
                answer++;
                curr++;
            } else if (!stack.isEmpty() && stack.peek() == o) {
                stack.pop();
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}