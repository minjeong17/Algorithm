import java.util.*;

class Solution {
    int[] number;
    public int solution(String[] want, int[] number, String[] discount) {
        this.number = number;
        int answer = 0;
        
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            idxMap.put(want[i], i);
        }
        
        int[] cnt = new int[want.length];
        for (int i = 0; i < 10; i++) {
            String w = discount[i];
            
            if (idxMap.containsKey(w)) {
                int idx = idxMap.get(w);
                cnt[idx]++;
            }
        }
        
        if (check(cnt)) answer++;
        
        for (int i = 0; i < discount.length - 10; i++) {
            if (idxMap.containsKey(discount[i])) {
                int idx = idxMap.get(discount[i]);
                cnt[idx]--;
            }
            
            if (idxMap.containsKey(discount[i+10])) {
                int idx = idxMap.get(discount[i+10]);
                cnt[idx]++;
            }
            
            if (check(cnt)) answer++;
        }
        
        
        return answer;
    }
    
    public boolean check(int[] cnt) {
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != number[i]) return false;
        }
        
        return true;
    }
}