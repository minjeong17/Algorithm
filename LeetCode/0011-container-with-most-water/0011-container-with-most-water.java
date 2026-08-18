import java.util.*;

class Solution {
    public int maxArea(int[] height) {
        int answer = 0;

        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            for (int j = height.length-1; j >= i; j--) {
                if (height[j] >= h) {
                    answer = Math.max(answer, h * (j - i));
                    break;
                }
            }
        }

        for (int i = height.length-1; i >= 0; i--) {
            int h = height[i];
            for (int j = 0; j <= i; j++) {
                if (height[j] >= h) {
                    answer = Math.max(answer, h * (i - j));
                    break;
                }
            }
        }
        
        return answer;
    }
}