import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] time = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            time[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        List<Integer> tmpAns = new ArrayList<>();
        int cnt = 1;
        int prev = time[0];
        for (int i = 1; i < progresses.length; i++) {
            if (time[i] <= prev) {
                cnt++;
            } else {
                tmpAns.add(cnt);
                cnt = 1;
                prev = time[i];
            }
        }
        tmpAns.add(cnt);
        
        int[] answer = new int[tmpAns.size()];
        for (int i = 0; i < tmpAns.size(); i++) {
            answer[i] = tmpAns.get(i);
        }
        
        return answer;
    }
}