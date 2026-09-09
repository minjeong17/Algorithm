import java.util.*;

class Solution {
    public long countCommas(long n) {
        if (n < 1000) return 0;

        long answer = 0;
        long t = 1000;
        while (n >= t) {
            answer += n - (t - 1);

            t *= 1000;
        }

        return answer;
    }
}