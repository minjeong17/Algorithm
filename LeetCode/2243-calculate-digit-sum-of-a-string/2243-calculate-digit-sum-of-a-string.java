import java.util.*;

class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            String sum = "";
            int tmp = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i > 0 && i % k == 0) {
                    sum += String.valueOf(tmp);
                    tmp = 0;
                }

                tmp += s.charAt(i) - '0';
            }

            sum += String.valueOf(tmp);

            s = sum;
        }

        return s;
    }
}