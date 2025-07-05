import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        Map<Integer, Integer> attack = new HashMap<>();
        for (int[] a : attacks) {
            attack.put(a[0], a[1]);
        }
        
        int successCnt = 0;
        for (int i = 1; i <= attacks[attacks.length-1][0]; i++) {
            if (attack.containsKey(i)) {
                answer -= attack.get(i);
                successCnt = 0;
                if (answer <= 0) return -1;
            } else {
                answer += x;
                successCnt++;
                if (successCnt == t) {
                    answer += y;
                    successCnt = 0;
                }
                if (answer > health) answer = health;
            }
        }
        
        
        return answer <= 0 ? -1 : answer;
    }
}