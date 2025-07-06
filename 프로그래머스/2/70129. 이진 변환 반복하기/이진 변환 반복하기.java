class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        StringBuilder tmp = new StringBuilder();
        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') tmp.append("1");
                else answer[1]++;
            }
            
            s = Integer.toBinaryString(tmp.length());
            tmp.setLength(0);
            answer[0]++;
        }
        
        return answer;
    }
}