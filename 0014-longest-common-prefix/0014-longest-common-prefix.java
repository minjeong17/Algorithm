import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> o1.length() - o2.length());

        StringBuilder answer = new StringBuilder(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < answer.length(); j++) {
                if (str.charAt(j) != answer.charAt(j)) {
                    answer.delete(j, answer.length());
                    break;
                }
            }
        }

        return answer.toString();
    }
}