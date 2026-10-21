import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            while (k > 0 && ans.length() > 0 && number.charAt(i) > ans.charAt(ans.length() - 1)) {
                ans.deleteCharAt(ans.length() - 1);
                k--;
            }
            
            ans.append(number.charAt(i));
        }
        
        while (k > 0 && ans.length() > 0) {
            ans.deleteCharAt(ans.length() - 1);
            k--;
        }
        
        return ans.toString();
    }
}