import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> sortedSc = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            sortedSc.add(score[i]);
            Collections.sort(sortedSc, (o1, o2) -> o2-o1);
            if (i < k-1) {
                answer[i] = sortedSc.get(sortedSc.size()-1);
            } else {
                answer[i] = sortedSc.get(k-1);
            }
        }
        
        return answer;
    }
}