import java.util.*;

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        StringBuilder answer = new StringBuilder();

        int[] sCnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCnt[s.charAt(i) - 'a']++;
        }

        outer:
        for (int i = 0; i < target.length(); i++) {
            char t = target.charAt(i);

            if (sCnt[t - 'a'] > 0) {
                answer.append(t);
                sCnt[t -'a']--;
            } else {
                int start = t - 'a' + 1;
                for (int j = start; j < 26; j++) {
                    if (sCnt[j] > 0) {
                        answer.append((char) (j + 'a'));
                        sCnt[j]--;
                        break outer;
                    }
                }

                // 백트래킹
                boolean flag = false;  
                outer2:
                for (int j = i - 1; j >= 0; j--) {
                    char curr = answer.charAt(j);
                    answer.deleteCharAt(j);
                    sCnt[curr - 'a']++;
                    for (int k = curr - 'a' + 1; k < 26; k++) {
                        if (sCnt[k] > 0) {
                            answer.append((char) (k + 'a'));
                            sCnt[k]--;
                            flag = true;
                            i = j;
                            break outer2;
                        }
                    }
                }
                if (!flag) return "";
                else break outer;
            }
        }

        if (answer.length() == 0) return "";

        if (answer.toString().equals(target)) {
            boolean flag = false;  
            outer:
            for (int j = answer.length() - 1; j >= 0; j--) {
                char curr = answer.charAt(j);
                answer.deleteCharAt(j);
                sCnt[curr - 'a']++;
                for (int k = curr - 'a' + 1; k < 26; k++) {
                    if (sCnt[k] > 0) {
                        answer.append((char) (k + 'a'));
                        sCnt[k]--;
                        flag = true;
                        break outer;
                    }
                }
            }

            if (!flag) return "";
        }

        if (answer.length() < target.length()) {
            for (int i = 0; i < 26; i++) {
                if (sCnt[i] > 0) {
                    for (int j = 0; j < sCnt[i]; j++) {
                        answer.append((char) (i + 'a'));
                    }
                }
            }
        }

        return target.equals(answer.toString()) ? "" : answer.toString();
    }
}