class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        int len = s.length();
        if (len % 2 == 0) {
            answer.append(s.charAt((len/2)-1)).append(s.charAt(len/2));
        } else {
            answer.append(s.charAt(len/2));
        }
        return answer.toString();
    }
}