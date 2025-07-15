import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> sc = new PriorityQueue<>();
        for (long s : scoville) sc.add(s);
        
        while (true) {
            long s1 = sc.poll();
            if (s1 >= K) break;
            else if (sc.size() == 0) {
                return -1;
            } else {
                long s2 = sc.poll();
                long newSc = s1 + (s2 * 2); 
                sc.add(newSc);
                answer++;
            }
        }
        
        return answer;
    }
}