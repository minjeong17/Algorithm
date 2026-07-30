import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for (int q : queue1) {
            q1.add(q);
            sum1 += q;
        }
        for (int q : queue2) {
            q2.add(q);
            sum2 += q;
        }
                
        while (answer <= queue1.length * 3) {
            if (sum1 > sum2) {
                int n = q1.poll();
                sum1 -= n;
                sum2 += n;
                q2.add(n);
                answer++;
            } else if (sum1 < sum2) {
                int n = q2.poll();
                sum2 -= n;
                sum1 += n;
                q1.add(n);
                answer++;
            }
            
            if (sum1 == sum2) return answer;
        }
        
        return -1;
    }
}