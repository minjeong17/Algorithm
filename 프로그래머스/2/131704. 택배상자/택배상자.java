import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        int curr = 1;
        int idx = 0;
        while (idx < order.length) {
            if (order[idx] == curr) {
                curr++;
                idx++;
                answer++;
            } else if (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                answer++;
            } else if (curr <= order[idx]){
                stack.push(curr);
                curr++;
            } else break;
        }
        
        return answer;
    }
}