import java.util.*;

class Solution {
    String[] want;
    int[] number;
    Map<String, Integer> idx, disc;
    public int solution(String[] want, int[] number, String[] discount) {
        this.want = want;
        this.number = number;
        
        int answer = 0;
        
        disc = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            disc.put(discount[i], disc.getOrDefault(discount[i], 0) + 1);
        }
        
        if (check()) answer++;
        
        for (int i = 10; i < discount.length; i++) {
            String prev = discount[i - 10];
            String curr = discount[i];
            
            if (disc.get(prev) == 1) disc.remove(prev);
            else disc.put(prev, disc.get(prev) - 1);
            
            disc.put(curr, disc.getOrDefault(curr, 0) + 1);
            
            if (check()) answer++;
        }
        
        return answer;
    }
    
    public boolean check() {
        for (int i = 0; i < want.length; i++) {
            String obj = want[i];
            
            if (!disc.containsKey(obj)) return false;
            else if (disc.get(obj) < number[i]) return false;
        }
        
        return true;
    }
}