import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int w : works) pq.add(w);
        
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) break;
            
            int c = pq.poll();
            if (c > 0) pq.add(c - 1);
        }
        
        while (!pq.isEmpty()) {
            int c = pq.poll();
            
            answer += c * c;
        }
        
        return answer;
    }
}