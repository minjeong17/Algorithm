import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        PriorityQueue<int[]> cnt = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) return o2[2] - o1[2];
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });
        
        int totalPicks = picks[0] + picks[1] + picks[2];
        
        int[] tmp = new int[3];
        for (int i = 0; i < Math.min(minerals.length, totalPicks * 5); i++) {
            if (i > 0 && i % 5 == 0) {
                cnt.add(tmp);
                tmp = new int[3];
            }
            
            if (minerals[i].equals("diamond")) tmp[0]++;
            else if (minerals[i].equals("iron")) tmp[1]++;
            else tmp[2]++;
        }
        cnt.add(tmp);
        
        while (!cnt.isEmpty()) {
            int[] curr = cnt.poll();
            
            if (picks[0] > 0) {
                answer += curr[0] + curr[1] + curr[2];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += curr[0] * 5 + curr[1] + curr[2];
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += curr[0] * 25 + curr[1] * 5 + curr[2];
                picks[2]--;
            } else break;
        }
        
        return answer;
    }
}