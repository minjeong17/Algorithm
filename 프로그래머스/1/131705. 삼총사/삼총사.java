import java.util.*;

class Solution {
    
    int answer, len;
    int[] sel;
    
    public int solution(int[] number) {
        
        answer = 0;
        len = number.length;
        sel = new int[3];    
        
        comb(0, 0, number);
        
        return answer;
    }
    
    public void comb(int idx, int sidx, int[] number) {
        if (sidx == 3) {
            if (sel[0] + sel[1] + sel[2] == 0) answer++;
            return;
        }
        
        for (int i = idx; i < len; i++) {
            sel[sidx] = number[i];
            comb(i+1, sidx+1, number);
        }
    }
}