import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            
            if (stack.isEmpty()) {
                stack.push(new int[] {num, i});
            } else {
                if (stack.peek()[0] < num) {
                    while (!stack.isEmpty() && stack.peek()[0] < num) {
                        int[] tmp = stack.pop();
                        answer[tmp[1]] = num;    
                    }
                }
                stack.push(new int[] {num, i});
            }
        }
        
        return answer;
    }
}