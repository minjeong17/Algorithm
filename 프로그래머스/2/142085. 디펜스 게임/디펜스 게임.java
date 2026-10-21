import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        int sum = 0;
        for (int i = 0; i < enemy.length; i++) {
            int e = enemy[i];
            
            sum += e;
            pq.add(e);
            
            if (sum > n) {
                int tmp = pq.poll();
                if (k > 0) {
                    sum -= tmp;
                    k--;
                } else {
                    break;
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}