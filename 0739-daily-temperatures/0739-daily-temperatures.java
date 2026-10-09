import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Stack<int[]> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int t = temperatures[i];
            if (stack.isEmpty()){
                answer[i] = 0;
                stack.push(new int[] {t, i});
            } else if (stack.peek()[0] > t) {
                answer[i] = stack.peek()[1] - i;
                stack.push(new int[] {t, i});
            } else if (stack.peek()[0] <= t) {
                while (!stack.isEmpty() && stack.peek()[0] <= t) {
                    stack.pop();
                }

                if (stack.isEmpty()) answer[i] = 0;
                else answer[i] = stack.peek()[1] - i;
                
                stack.push(new int[] {t, i});
            }
        }

        return answer;
    }
}