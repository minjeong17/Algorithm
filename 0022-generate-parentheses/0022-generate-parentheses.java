import java.util.*;

class Solution {
    int n;
    List<String> answer;
    StringBuilder tmp;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        answer = new ArrayList<>();

        tmp = new StringBuilder();
        dfs(0, 0);

        return answer;
    }

    public void dfs(int open, int close) {
        if (tmp.length() == n * 2) {
            answer.add(tmp.toString());
            return;
        }

        if (open < n) {
            tmp.append("(");
            dfs(open+1, close);
            tmp.deleteCharAt(tmp.length() - 1);
        }

        if (close < open) {
            tmp.append(")");
            dfs(open, close+1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}