import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Stack<int[]> stack = new Stack<>();
        int maxT = Integer.MIN_VALUE;
        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (!stack.isEmpty() && temperatures[i] < maxT) {
                while (!stack.isEmpty() && stack.peek()[0] <= temperatures[i]) {
                    stack.pop();
                }

                answer[i] = stack.peek()[1] - i;
            }

            stack.push(new int[] {temperatures[i], i});
            maxT = Math.max(maxT, temperatures[i]);
        }

        return answer;
    }
}