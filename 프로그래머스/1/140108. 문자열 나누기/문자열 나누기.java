class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char currCh = s.charAt(0);
        int cntSame = 0, cntDiff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == currCh) cntSame++;
            else cntDiff++;
            
            if (cntSame == cntDiff) {
                answer++;
                if (i + 1 < s.length()) {
                    currCh = s.charAt(i+1);
                    
                }
                cntSame = 0;
                cntDiff = 0;
            } 
            
        }
        
        return cntSame != cntDiff ? answer+1 : answer;
    }
}