import java.util.*;

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        if (s.length() == 1) {
            if (target.compareTo(s) >= 0) return "";
            else return s;
        }

        StringBuilder answer = new StringBuilder();

        int len = target.length();
        int[] sCnt = new int[26];
        for (int i = 0; i < len; i++) {
            sCnt[s.charAt(i) - 'a']++;
        }

        int midCnt = 0;
        char mid = '\u0000';
        for (int i = 0; i < 26; i++) {
            if (sCnt[i] % 2 == 1) {
                midCnt++;
                mid = (char) (i + 'a');
            }
        }

        if (len % 2 == 1 && midCnt != 1) return "";
        if (len % 2 == 0 && midCnt != 0) return "";

        outer:
        for (int i = 0; i < len / 2; i++) {
            char t = target.charAt(i);
            if (sCnt[t - 'a'] >= 2) {
                answer.append(t);
                sCnt[t - 'a'] -= 2;
            } else {
                for (int j = t - 'a' + 1; j < 26; j++) {
                    if (sCnt[j] >= 2) {
                        answer.append((char) (j + 'a'));
                        sCnt[j] -= 2;
                        break outer;
                    }
                }

                // 백트래킹
                for (int j = i - 1; j >= 0; j--) {
                    char curr = answer.charAt(j);
                    answer.deleteCharAt(j);
                    sCnt[curr - 'a'] += 2;
                    for (int k = curr - 'a' + 1; k < 26; k++) {
                        if (sCnt[k] >= 2) {
                            answer.append((char) (k + 'a'));
                            sCnt[k] -= 2;
                            break outer;
                        }
                    }
                }

                return "";
            }
        }

        if (answer.length() < len / 2) {
            for (int i = 0; i < 26; i++) {
                if (sCnt[i] >= 2) {
                    int c = sCnt[i] / 2;
                    for (int j = 0; j < c; j++) {
                        answer.append((char) (i + 'a'));
                        sCnt[i] -= 2;
                    }
                }
            }
        }

        String tmp;
        if (len % 2 == 0) tmp = answer.toString() + answer.reverse().toString();
        else tmp = answer.toString() + mid + answer.reverse().toString();

        answer.reverse();

        if (tmp.compareTo(target) <= 0) {
            // 백트래킹
            boolean found = false;
            outer:
            for (int j = answer.length() - 1; j >= 0; j--) {
                char curr = answer.charAt(j);
                answer.deleteCharAt(j);
                sCnt[curr - 'a'] += 2;
                for (int k = curr - 'a' + 1; k < 26; k++) {
                    if (sCnt[k] >= 2) {
                        answer.append((char) (k + 'a'));
                        sCnt[k] -= 2;
                        found = true;
                        break outer;
                    }
                }
            }

            if (!found) return "";
        }

        if (answer.length() < len / 2) {
            for (int i = 0; i < 26; i++) {
                if (sCnt[i] >= 2) {
                    int c = sCnt[i] / 2;
                    for (int j = 0; j < c; j++) {
                        answer.append((char) (i + 'a'));
                        sCnt[i] -= 2;
                    }
                }
            }
        }

        if (len % 2 == 0) return answer.toString() + answer.reverse().toString();
        else return answer.toString() + mid + answer.reverse().toString();
    }
}