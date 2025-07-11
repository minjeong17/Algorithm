import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[numbers.length-1]);
        for (int i = numbers.length-2; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peek() > numbers[i]) {
                    answer[i] = stack.peek();
                    stack.push(numbers[i]);
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty())
                stack.push(numbers[i]);
        }
        
        return answer;
    }
}