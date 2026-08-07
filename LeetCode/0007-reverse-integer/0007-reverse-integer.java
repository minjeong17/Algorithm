import java.util.*;

class Solution {
    public int reverse(int x) {
        StringBuilder xStr;

        if (x >= 0) {
            xStr = new StringBuilder(Long.toString(x));

            String revX = xStr.reverse().toString();
            if (Long.parseLong(revX) > Integer.MAX_VALUE) {
                return 0;
            } else {
                return Integer.parseInt(revX);
            }
        } else {
            xStr = new StringBuilder(Long.toString((long) x * (-1)));

            String revX = xStr.reverse().toString();
            if (Long.parseLong(revX) * (-1) < Integer.MIN_VALUE) {
                return 0;
            } else {
                return -Integer.parseInt(revX);
            }
        }
    }
}