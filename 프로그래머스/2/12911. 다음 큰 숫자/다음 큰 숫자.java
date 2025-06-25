import java.util.*;

class Solution {
    public int solution(int n) {
        
        int nCount = Integer.bitCount(n);
        
        int tmp = n+1;
        while (true) {
            
            if (nCount == Integer.bitCount(tmp)) {
                return tmp;
            }
            
            tmp++;
        }
    }
}