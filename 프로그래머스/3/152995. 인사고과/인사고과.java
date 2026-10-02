import java.util.*;

class Solution {
    public int solution(int[][] scores) {        
        int[] wh = {scores[0][0], scores[0][1]};
        int sum = wh[0] + wh[1];
        
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        
        int answer = 1;
        List<Integer> getIncentive = new ArrayList<>();
        int maxSc = Integer.MIN_VALUE;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i][1] >= maxSc) {
                getIncentive.add(scores[i][0] + scores[i][1]);
                maxSc = Math.max(maxSc, scores[i][1]);
                
                if (scores[i][0] + scores[i][1] > sum) answer++;
            } else {
                if (scores[i][0] == wh[0] && scores[i][1] == wh[1]) return -1;
            }
            
        }
                        
        return answer;
    }
}