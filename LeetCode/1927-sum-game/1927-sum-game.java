import java.util.*;

class Solution {
    public boolean sumGame(String num) {
        int len = num.length();
        
        int sum1 = 0;
        int sum2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
   
            if (i < len / 2) {
                if (c == '?') cnt1++;
                else sum1 += c - '0';
            } else {
                if (c == '?') cnt2++;
                else sum2 += c - '0';
            }
        }

        if ((cnt1 + cnt2) % 2 == 1) return true;
        if (2 * (sum1 - sum2) == 9 * (cnt2 - cnt1)) return false;
        else return true;
    }
}