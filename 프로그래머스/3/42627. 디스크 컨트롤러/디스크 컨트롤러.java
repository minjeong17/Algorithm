import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) return o1[2] - o2[2];
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        }); // [소요시간, 요청시각, 작업번호]
        
        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        
        int time = jobs[0][0];
        int idx = 0;
        while (idx < jobs.length && jobs[idx][0] == time) {
            pq.add(new int[] {jobs[idx][1], jobs[idx][0], idx});
            idx++;
        }

        int completed = 0;
        while (completed < jobs.length) {
            int[] curr = pq.poll();
            
            time += curr[0];
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(new int[] {jobs[idx][1], jobs[idx][0], idx});
                idx++;
            }
            
            answer += time - curr[1];
            completed++;
            
            if (pq.isEmpty() && idx < jobs.length) {
                time = jobs[idx][0];
                while (idx < jobs.length && jobs[idx][0] <= time) {
                    pq.add(new int[] {jobs[idx][1], jobs[idx][0], idx});
                    idx++;
                }
            }
        }
        
        
        return answer / jobs.length;
    }
}