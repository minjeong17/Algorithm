import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();
        
        int len = elements.length;

        int[] cirEl = new int[len * 2];
        int total = 0;
        for (int i = 0; i < cirEl.length; i++) {
            cirEl[i] = elements[i % len];
            total += cirEl[i];
            sumSet.add(cirEl[i]);
        }
        sumSet.add(total / 2);
        
        for (int l = 2; l < len; l++) {
            int left = 0;
            int right = l - 1;
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += cirEl[i];
            }
            sumSet.add(sum);
            
            while (left <= len) {
                sum -= cirEl[left++];
                sum += cirEl[++right];
                
                sumSet.add(sum);
            }
        }
        
        return sumSet.size();
    }
}