import java.util.*;

class Solution {
    public int myAtoi(String s) {
        long answer = 0;
        s = s.trim();

        boolean isNegative = false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '-') {
                    isNegative = true;
                    continue;
                } else if (s.charAt(i) == '+') continue;
            }

            char c = s.charAt(i);
            if (c - '0' >= 0 && c - '0' <= 9) answer = answer * 10 + (c - '0');
            else break;

            if (answer > Integer.MAX_VALUE) break;
        }

        if (answer == 0) return 0;
        else {
            if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) {
                if (isNegative) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            } else {
                if (isNegative) return (int) answer * (-1);
                else return (int) answer;
            }    
        }
    }
}