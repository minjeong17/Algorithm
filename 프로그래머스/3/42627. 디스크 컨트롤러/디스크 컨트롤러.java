import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) return o1[2] - o2[2];
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }); // [소요시간, 요청시각, 번호]
        
        int idx = 0;
        while (idx < jobs.length && jobs[idx][0] == jobs[0][0]) {
            pq.add(new int[] {jobs[idx][1], jobs[idx][0], idx});
            idx++;
        }
        
        int currT = jobs[0][0];
        int total = 0;
        while (!pq.isEmpty()) {            
            int[] job = pq.poll();
            
            currT += job[0];
            total += currT - job[1];
            
            while (idx < jobs.length && jobs[idx][0] <= currT) {
                pq.add(new int[] {jobs[idx][1], jobs[idx][0], idx});
                idx++;
            }
            
            if (idx < jobs.length && pq.isEmpty()) {
                currT = jobs[idx][0];
                while (idx < jobs.length && jobs[idx][0] == currT) {
                    pq.add(new int[] {jobs[idx][1], jobs[idx][0], idx});
                    idx++;
                }
            }
        }
        
        return total / jobs.length;
    }
}