import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int n : win_nums) {
            hmap.put(n, 0);
        }
        
        int cnt0 = 0;
        int cntCorrect = 0;
        for (int num : lottos) {
            if (num == 0) cnt0++;
            if (hmap.containsKey(num)) cntCorrect++;
        }
        
        answer[0] = cntCorrect+cnt0 == 0 ? 6 : 7-(cntCorrect+cnt0);
        answer[1] = cntCorrect == 0 ? 6 : 7-cntCorrect;
        
        return answer;
    }
}