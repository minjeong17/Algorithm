import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            int curr = value(s.charAt(i));
            if (i < s.length() - 1 && curr < value(s.charAt(i + 1))) {
                answer -= curr;
            } else {
                answer += curr;
            }
        }

        return answer;
    }

    public int value(char c) {
        if (c == 'I') return 1;
        else if (c == 'V') return 5;
        else if (c == 'X') return 10;
        else if (c == 'L') return 50;
        else if (c == 'C') return 100;
        else if (c == 'D') return 500;
        else if (c == 'M') return 1000;

        return 0;
    }
}