import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            q.add(new int[] {priorities[i], i});
        }
        
        while (!q.isEmpty()) {
            int[] process = q.poll();
            
            if (process[0] == pq.peek()) {
                answer++;
                if (process[1] == location) break;
                pq.poll();
            } else {
                q.add(process);
            }
        }
        
        return answer;
    }
}