class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        boolean wordStart = true;
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                answer.append(" ");
                wordStart = true;
            } else {
                if (wordStart) {
                    answer.append((s.charAt(i)+"").toUpperCase());
                    wordStart = false;
                } else {
                    answer.append((s.charAt(i)+"").toLowerCase());
                }
            }
        }
        
        return answer.toString();
    }
}