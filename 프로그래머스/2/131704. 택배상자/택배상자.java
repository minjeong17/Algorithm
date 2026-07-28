import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> cb = new Stack<>();
        int curr = 1;
        int idx = 0;
        while (idx < order.length) {
            if (curr <= order.length && curr == order[idx]) {
                answer++;
                idx++;
                curr++;
            } else if (!cb.isEmpty() && cb.peek() == order[idx]) {
                answer++;
                idx++;
                cb.pop();
            } else {
                if (curr <= order[idx]) {
                    cb.push(curr);
                    curr++;
                } else break;
            }
        }
         
        return answer;
    }
}