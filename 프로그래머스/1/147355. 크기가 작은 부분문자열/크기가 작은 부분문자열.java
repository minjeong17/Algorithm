class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int len = p.length();
        long pNum = Long.parseLong(p);
        
        for (int i = 0; i <= t.length()-len; i++) {
            String tmp = t.substring(i, i+len);
            if (Long.parseLong(tmp) <= pNum) answer++;
        }
        
        return answer;
    }
}