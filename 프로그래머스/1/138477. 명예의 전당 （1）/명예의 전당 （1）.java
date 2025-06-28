import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> sortedSc = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            sortedSc.add(score[i]);
            if (sortedSc.size() > k) {
                sortedSc.poll();
            }
            
            answer[i] = sortedSc.peek();
        }
        
        return answer;
    }
}