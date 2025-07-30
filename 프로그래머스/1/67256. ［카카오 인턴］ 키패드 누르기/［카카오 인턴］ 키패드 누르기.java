import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        Map<Integer, int[]> numPos = new HashMap<>();
        numPos.put(1, new int[] {0, 0}); numPos.put(2, new int[] {0, 1}); numPos.put(3, new int[] {0, 2}); 
        numPos.put(4, new int[] {1, 0}); numPos.put(5, new int[] {1, 1}); numPos.put(6, new int[] {1, 2}); 
        numPos.put(7, new int[] {2, 0}); numPos.put(8, new int[] {2, 1}); numPos.put(9, new int[] {2, 2}); 
        numPos.put(0, new int[] {3, 1});
        
        int[] left = new int[] {3, 0};
        int[] right = new int[] {3, 2};
        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                answer.append('L');
                left[0] = n / 3;
                left[1] = 0;
            } else if (n == 3 || n == 6 || n == 9) {
                answer.append('R');
                right[0] = (n - 3) / 3;
                right[1] = 2;
            } else {
                int[] pos = numPos.get(n);
                int tmpLeft = Math.abs(pos[0] - left[0]) + Math.abs(pos[1] - left[1]);
                int tmpRight = Math.abs(pos[0] - right[0]) + Math.abs(pos[1] - right[1]);
                
                if (tmpLeft < tmpRight) {
                    answer.append('L');
                    left[0] = pos[0];
                    left[1] = pos[1];
                } else if (tmpRight < tmpLeft) {
                    answer.append('R');
                    right[0] = pos[0];
                    right[1] = pos[1];
                } else {
                    if ("left".equals(hand)) {
                        answer.append('L');
                        left[0] = pos[0];
                        left[1] = pos[1];
                    } else {
                        answer.append('R');
                        right[0] = pos[0];
                        right[1] = pos[1];                        
                    }
                }
            }
        }
        
        return answer.toString();
    }
}