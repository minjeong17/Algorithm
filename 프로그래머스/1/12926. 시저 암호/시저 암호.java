class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == ' ') answer.append(" ");
            else if (curr >= 65 && curr <= 90) {
                answer.append(curr + n > 90 ? (char) (curr+n-26) : (char) (curr+n));
            } else if (curr >= 97 && curr <= 122) {
                answer.append(curr + n > 122 ? (char) (curr+n-26) : (char) (curr+n));
            }
        }
        
        return answer.toString();
    }
}
