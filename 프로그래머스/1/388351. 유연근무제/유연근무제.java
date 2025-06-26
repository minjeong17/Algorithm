import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i < schedules.length; i++) {
            boolean isOk = true;
            for (int j = 0; j < 7; j++) {
                int today = (j + startday + 7) % 7;
                if (today >= 1 && today <= 5) {
                    
                    int time = schedules[i] + 10;
                    if (time % 100 >= 60) {  // 761
                        int h = (time / 100) + 1;
                        int m = (time % 100) - 60;
                        time = h * 100 + m;
                    }
                    
                    if (time < timelogs[i][j]) {
                        isOk = false;
                        break;
                    }
                }
            }
            if (isOk) answer++;
        }
        
        return answer;
    }
}