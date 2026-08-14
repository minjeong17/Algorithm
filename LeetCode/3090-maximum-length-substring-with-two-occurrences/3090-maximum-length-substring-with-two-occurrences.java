import java.util.*;

class Solution {
    public int maximumLengthSubstring(String s) {
        int answer = 0;

        int[] cnt = new int[26];

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'a';

            cnt[idx]++;

            while (cnt[idx] > 2) {
                int leftIdx = s.charAt(left) - 'a';
                cnt[leftIdx]--;

                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}