import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {
        int answer = 0;

        int[] alphaCnt = new int[26];
        int maxCnt = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            alphaCnt[ch - 'A']++;
            maxCnt = Math.max(maxCnt, alphaCnt[ch - 'A']);

            while (right - left + 1 - maxCnt > k) {
                alphaCnt[s.charAt(left) - 'A']--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}