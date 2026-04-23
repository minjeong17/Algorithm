import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int totalP = 0;
        for (int pick : picks) totalP += pick;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) return o2[2] - o1[2];
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });
        int diaCnt = 0;
        int ironCnt = 0;
        int stoneCnt = 0;
        for (int i = 0; i < minerals.length; i++) {
            if (i > 0 && i % 5 == 0 && pq.size() < totalP) {
                pq.add(new int[] {diaCnt, ironCnt, stoneCnt});
                diaCnt = 0;
                ironCnt = 0;
                stoneCnt = 0;
            }
            
            if (minerals[i].equals("diamond")) diaCnt++;
            else if (minerals[i].equals("iron")) ironCnt++;
            else stoneCnt++;
        }
        if (diaCnt + ironCnt + stoneCnt > 0 && pq.size() < totalP) pq.add(new int[] {diaCnt, ironCnt, stoneCnt});
                
        for (int i = 0; i < 3; i++) {
            int p = picks[i];
            while (p > 0 && !pq.isEmpty()) {
                int[] curr = pq.poll();
                if (i == 0) {
                    answer += curr[0];
                    answer += curr[1];
                    answer += curr[2];
                } else if (i == 1) {
                    answer += curr[0] * 5;
                    answer += curr[1];
                    answer += curr[2];
                } else {
                    answer += curr[0] * 25;
                    answer += curr[1] * 5;
                    answer += curr[2];
                }
                
                p--;
            }
        }
        
        return answer;
    }
}