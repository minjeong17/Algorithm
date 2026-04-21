import java.util.*;

class Solution {
    public List<Integer> nums;
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        nums = new ArrayList<>();
        nums.add(k);
        hailstone(k);
        
        int size = nums.size();
        double[] sums = new double[size];
        for (int i = 1; i < size; i++) {
            sums[i] = sums[i-1] + (nums.get(i) + nums.get(i-1)) / 2.0;
        }
        
        for (int i = 0; i < ranges.length; i++) {
            int[] r = ranges[i];
            int a = r[0];
            int b = size - 1 + r[1];
            
            if (a > b) answer[i] = -1.0;
            else answer[i] = sums[b] - sums[a];
        }
        
        return answer;
    }
    
    public void hailstone(int k) {
        while (k > 1) {
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
            
            nums.add(k);
        }
    }
}