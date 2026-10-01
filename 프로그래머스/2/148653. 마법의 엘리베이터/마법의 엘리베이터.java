import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int n = storey % 10;
            
            if (n < 5) answer += n;
            else if (n > 5) {
                answer += 10 - n;
                storey += 10 - n;
            } else {
                int t = (storey / 10) % 10;
                if (t >= 5) storey += 5;
                
                answer += n;
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}