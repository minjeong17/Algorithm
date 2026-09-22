import java.util.*;

class Solution {
    String digits;
    List<String> answer;
    Map<Character, char[]> letters;
    StringBuilder tmp;
    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        answer = new ArrayList<>();

        letters = new HashMap<>();
        letters.put('2', new char[] {'a', 'b', 'c'});
        letters.put('3', new char[] {'d', 'e', 'f'});
        letters.put('4', new char[] {'g', 'h', 'i'});
        letters.put('5', new char[] {'j', 'k', 'l'});
        letters.put('6', new char[] {'m', 'n', 'o'});
        letters.put('7', new char[] {'p', 'q', 'r', 's'});
        letters.put('8', new char[] {'t', 'u', 'v'});
        letters.put('9', new char[] {'w', 'x', 'y', 'z'});

        tmp = new StringBuilder();
        dfs(0);

        return answer;
    }

    public void dfs(int d) {
        if (tmp.length() == digits.length()) {
            answer.add(tmp.toString());
            return;
        }

        for (char c : letters.get(digits.charAt(d))) {
            tmp.append(c);
            dfs(d + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}