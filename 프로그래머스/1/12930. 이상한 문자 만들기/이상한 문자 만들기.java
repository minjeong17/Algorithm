class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        int flag = 2;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer.append(" ");
                flag = 2;
            } else {
                if (flag % 2 == 0) {
                    answer.append((s.charAt(i)+"").toUpperCase());
                } else {
                    answer.append((s.charAt(i)+"").toLowerCase());
                }
                flag++;
            }
        }
        
        return answer.toString();
    }
}