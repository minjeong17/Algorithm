import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);

        for (int i = 1; i < asteroids.length; i++) {
            int curr = asteroids[i];
            
            if (stack.isEmpty()) stack.push(curr);
            else if (stack.peek() < 0) {
                stack.push(curr);
            } else {
                if (curr > 0) stack.push(curr);
                else {
                    while (!stack.isEmpty() && curr * stack.peek() < 0 && Math.abs(curr) > Math.abs(stack.peek())) {
                        if (Math.abs(curr) > Math.abs(stack.peek())) {
                            stack.pop();
                        }
                    }

                    if (!stack.isEmpty() && Math.abs(curr) >= Math.abs(stack.peek())) {
                        if (curr * stack.peek() > 0) stack.push(curr);
                        else stack.pop();
                    } else {
                        if (stack.isEmpty() || (!stack.isEmpty() && curr * stack.peek() > 0)) stack.push(curr);
                    }
                }
            }
        }

        int idx = stack.size() - 1;
        int[] answer = new int[stack.size()];
        for (int i = idx; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}