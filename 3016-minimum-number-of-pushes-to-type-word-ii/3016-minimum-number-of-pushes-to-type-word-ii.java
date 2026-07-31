import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        int[] cntArr = new int[26];
        for (char c : word.toCharArray()) cntArr[c - 'a']++;

        Arrays.sort(cntArr);

        int answer = 0;
        int n = 0;
        for (int i = 25; i >= 0; i--) {
            int c = cntArr[i];
            if (c == 0) break;

            answer += c * ((n / 8) + 1);
            n++;
        }

        return answer;
    }
}