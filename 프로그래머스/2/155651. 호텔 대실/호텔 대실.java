import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[] times = new int[1450];
        for (String[] bk : book_time) {
            int startT = parseTime(bk[0]);
            int endT = parseTime(bk[1]);
            
            for (int j = startT; j < endT+10; j++) times[j]++;
        }
        
        for (int v : times) answer = Math.max(answer, v);
        
        return answer;
    }
    
    public int parseTime(String time) {
        String[] t = time.split(":");
        
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}