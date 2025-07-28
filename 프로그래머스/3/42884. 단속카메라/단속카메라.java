import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
            
        int cam = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (route[0] > cam || route[1] < cam) {
                cam = route[1];
                answer++;
            } 
        }
        
        return answer;
    }
}