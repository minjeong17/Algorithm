import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        int idx = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) q.add(-1);
        
        while (idx < truck_weights.length) {
            if (!q.isEmpty()) {
                int tmp = q.poll();
                if (tmp != -1) sum -= tmp;
            }
            
            int curr = truck_weights[idx];
            if (sum + curr <= weight) {
                q.add(curr);
                sum += curr;
                idx++;
            } else {
                q.add(-1);
            }
            
            time++;    
        }
        
        while (!q.isEmpty()) {
            q.poll();
            time++;
        }
        
        return time;
    }
}