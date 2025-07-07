import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> cntFruits = new HashMap<>();
        for (int t : tangerine) {
            cntFruits.put(t, cntFruits.getOrDefault(t, 0) + 1);
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o2[1] - o1[1];
        });
        for (int n : cntFruits.keySet()) {
            q.add(new int[] {n, cntFruits.get(n)});
        }
        
        int sum = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            sum += curr[1];
            answer++;
            
            if (sum >= k) break;
        }
        
        return answer;
    }
}