import java.util.*;

class Solution {
    String answer;
    int maxLen;
    public String longestPalindrome(String s) {
        answer = s.substring(0, 1);
        maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            check(s, i-1, i+1);
            check(s, i, i+1);
        }

        return answer;
    }

    public void check(String s, int l, int r) {
        int left = l;
        int right = r;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                if (maxLen < right - left + 1) {
                    maxLen = right - left + 1;
                    answer = s.substring(left, right+1);
                }

                left--;
                right++;
            }  else break;
        }
    }
}