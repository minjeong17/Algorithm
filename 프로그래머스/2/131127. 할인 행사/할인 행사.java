import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            cnt.put(want[i], number[i]);
        }
        
        int sum = 0;
        for (int n : number) sum += n;
        
        Map<String, Integer> tmp = new HashMap<>();
        
        for (int i = 0; i <= discount.length - sum; i++) {
            tmp.putAll(cnt);
            
            boolean isOk = true;
            for (int j = i; j < i + sum; j++) {
                if (!tmp.containsKey(discount[j])) {
                    isOk = false;
                    break;
                } else {
                    if (tmp.get(discount[j]) == 1) tmp.remove(discount[j]);
                    else {
                        tmp.put(discount[j], tmp.get(discount[j])-1);
                    }
                }
            }
            
            if (isOk && tmp.size() == 0) {
                answer++;
            }
        }
         
        return answer;
    }
}