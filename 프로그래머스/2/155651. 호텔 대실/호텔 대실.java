import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        
        for (String[] bt : book_time) {
            String[] s = bt[0].split(":");
            String[] e = bt[1].split(":");
            
            pq.add(new int[] {Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]), 
                              Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1])});
        }
        
        PriorityQueue<Integer> endTime = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            
            if (!endTime.isEmpty() && endTime.peek() + 10 <= t[0]) {
                endTime.poll();
                endTime.add(t[1]);
            } else {
                endTime.add(t[1]);
                answer++;
            }
        }

        
        return answer;
    }
}