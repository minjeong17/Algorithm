import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int len = enroll.length;
        int[] answer = new int[len];
        
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            idxMap.put(enroll[i], i);
        }
        
        Map<String, String> ref = new HashMap<>();
        for (int i = 0; i < len; i++) {
            ref.put(enroll[i], referral[i]);
        }
        
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int profit = amount[i] * 100;
            while (ref.containsKey(name)) {                
                int idx = idxMap.get(name);
                answer[idx] += profit - (profit / 10);
                
                profit /= 10;
                name = ref.get(name);
                
                if (profit == 0) break;
            }
        }
        
        return answer;
    }
}