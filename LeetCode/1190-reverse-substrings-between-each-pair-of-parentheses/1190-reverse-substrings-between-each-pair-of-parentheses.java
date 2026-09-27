import java.util.*;

class Solution {
    public String reverseParentheses(String s) {
        StringBuilder answer = new StringBuilder(s);

        String left = "";
        String middle = "";
        String right = "";
        while (answer.lastIndexOf("(") >= 0) {
            int openIdx = answer.lastIndexOf("(");
            int closeIdx = answer.indexOf(")", openIdx);

            if (openIdx + 1 == closeIdx) {
                left = answer.substring(0, openIdx);
                right = answer.substring(closeIdx+1);

                answer.setLength(0);
                answer.append(left).append(right);
            } else {
                left = answer.substring(0, openIdx);
                middle = answer.substring(openIdx+1, closeIdx);
                StringBuilder tmp = new StringBuilder(middle);
                right = answer.substring(closeIdx+1);

                answer.setLength(0);
                answer.append(left).append(tmp.reverse()).append(right);
            }
        }

        return answer.toString();
    }
}