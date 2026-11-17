import java.util.*;

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek()[0] != c - 'a') {
                stack.push(new int[] {c - 'a', 1});
            } else {
                if (stack.peek()[1] == k - 1) stack.pop();
                else stack.peek()[1]++;
            }
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            for (int i = 0; i < curr[1]; i++) answer.append((char) (curr[0] + 97));
        }

        return answer.reverse().toString();
    }
}