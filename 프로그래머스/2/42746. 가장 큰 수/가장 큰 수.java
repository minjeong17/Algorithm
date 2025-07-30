import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] strNums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNums[i] = numbers[i]+"";
        }
        
        Arrays.sort(strNums, (o1, o2) -> {
            return (o2+o1).compareTo(o1+o2);
        });
        
        StringBuilder ans = new StringBuilder();
        for (String n : strNums) {
            if ("0".equals(n) && ans.length() == 0) continue;
            ans.append(n);
        }
            
        return ans.length() == 0 ? "0" : ans.toString();
    }
}