import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();

        int curr = 1;
        int idx = 0;
        while (curr <= order.length) {
            if (order[idx] == curr) {
                answer++;
                curr++;
                idx++;
            } else if (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
            } else {
                stack.push(curr);
                curr++;
            }
        }
        
        while (!stack.isEmpty()) {
            if (stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
            } else break;
        }
        
        
        return answer;
    }
}