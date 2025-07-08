import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> tmp = new ArrayList<>();
        
        int[] left = new int[speeds.length];
        for (int i = 0; i < left.length; i++) {
            int t = (100 - progresses[i]) / speeds[i];
            left[i] = (100 - progresses[i]) % speeds[i] == 0 ? t : t + 1;
        }
        
        int count = 1;
        int prev = left[0];
        for (int i = 1; i < left.length; i++) {
            if (left[i] <= prev) {
                count++;
            } else {
                tmp.add(count);
                count = 1;
                prev = left[i];
            }
        }

        tmp.add(count); 
        
        
        int[] answer = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }
        
        return answer;
    }
}