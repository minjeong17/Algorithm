import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> work = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int w : works) work.add(w);
        
        for (int i = 0; i < n; i++) {
            if (!work.isEmpty()) {
                int w = work.poll();
                if (w > 1) work.add(w - 1);
            }
        }
        
        int size = work.size();
        for (int i = 0; i < size; i++) {
            long w = work.poll();
            answer += (w * w);
        }
        
        return answer;
    }
}