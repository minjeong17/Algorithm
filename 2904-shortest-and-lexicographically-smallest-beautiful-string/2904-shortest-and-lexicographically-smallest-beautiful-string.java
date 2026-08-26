import java.util.*;

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String answer = "";
        int minLen = Integer.MAX_VALUE;

        int cnt1 = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') cnt1++;

            if (cnt1 == k) {
                while (s.charAt(left) == '0') {
                    left++;
                }

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    answer = s.substring(left, right + 1);
                } else if (right - left + 1 == minLen) {
                    String curr = s.substring(left, right + 1);
                    for (int i = 0; i < minLen; i++) {
                        if (curr.charAt(i) < answer.charAt(i)) {
                            answer = curr;
                            break;
                        } else if (curr.charAt(i) > answer.charAt(i)) break;
                    } 
                }

                left++;
                cnt1--;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : answer;
    }
}