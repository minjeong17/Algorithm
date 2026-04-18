import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            if (n % 3 == 1) {
                ans.append(1);
                n /= 3;
            } else if (n % 3 == 2) {
                ans.append(2);
                n /= 3;
            } else {
                ans.append(4);
                n = (n / 3) - 1;
            }
        }
        
        
        return ans.reverse().toString();
    }
}