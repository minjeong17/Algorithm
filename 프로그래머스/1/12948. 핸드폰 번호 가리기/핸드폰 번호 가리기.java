class Solution {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        
        int len = phone_number.length();
        
        for (int i = 0; i < len-4; i++) answer.append("*");
        
        for (int i = len-4; i < len; i++) answer.append(phone_number.charAt(i));
        
        return answer.toString();
    }
}