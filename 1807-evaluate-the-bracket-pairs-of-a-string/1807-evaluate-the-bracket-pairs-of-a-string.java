import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> know = new HashMap<>();
        for (List<String> k : knowledge) {
            know.put("(" + k.get(0), k.get(1));
        }

        StringBuilder answer = new StringBuilder();
        StringBuilder keyword = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') keyword.append("(");
            else if (c == ')') {
                answer.append(know.getOrDefault(keyword.toString(), "?"));
                keyword.setLength(0);
            } else {
                if (keyword.isEmpty()) answer.append(c);
                else keyword.append(c);
            }
        }

        return answer.toString();
    }
}