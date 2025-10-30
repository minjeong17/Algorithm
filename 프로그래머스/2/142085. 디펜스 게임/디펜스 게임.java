import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        if (enemy.length <= k) return enemy.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1); 
        
        int sum = 0;
        for (int e : enemy) {
            sum += e;
            pq.add(e);
            answer++;
            
            if (sum <= n) continue;
            
            if (sum > n && k > 0) {
                int tmp = pq.poll();
                sum -= tmp;
                k--;
            } else {
                return --answer;
            }
        }
        
        return answer;
    }
}