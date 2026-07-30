import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        int answer = 0;

        int len = word.length();
        int m = 1;
        while (len > 0) {
            if (len >= 8) {
                len -= 8;
                answer += 8 * m;
            } else {
                answer += len * m;
                len = 0;
            }

            m++;
        }
        
        return answer;
    }
}