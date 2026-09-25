import java.util.*;

class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign = true;
        if (dividend > 0 && divisor < 0) sign = false;
        if (dividend < 0 && divisor > 0) sign = false;

        long a = dividend;
        long b = divisor;

        if (a < 0) a = -a;
        if (b < 0) b = -b;

        long answer = 0;
        while (a >= b) {
            long tmp = b;
            long count = 1;
            while (tmp + tmp <= a) {
                tmp += tmp;
                count += count;
            }

            answer += count;
            a -= tmp;
        }

        if (!sign) answer = -answer;

        if (answer > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (answer < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) answer;
    }
}