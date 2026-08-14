import java.util.*;

class Solution {
    public int maximumLengthSubstring(String s) {
        int answer = 0;

        Map<Character, Integer> cntMap = new HashMap<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);

            while (cntMap.get(c) == 3) {
                char r = s.charAt(left);
                cntMap.put(r, cntMap.get(r) - 1);

                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}