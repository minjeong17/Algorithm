import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] std1 = {1, 2, 3, 4, 5};  
        int[] std2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] std3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] ansCnt = new int[4];
        
        for (int i = 0; i < answers.length; i++) {
            int ans = answers[i];
            
            if (ans == std1[i % 5]) ansCnt[1]++;
            if (ans == std2[i % 8]) ansCnt[2]++;
            if (ans == std3[i % 10]) ansCnt[3]++;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, ansCnt[1]});
        for (int i = 2; i <= 3; i++) {
            if (q.peek()[1] < ansCnt[i]) {
                q.poll();
                q.add(new int[] {i, ansCnt[i]}); 
            } else if (q.peek()[1] == ansCnt[i]) {
                q.add(new int[] {i, ansCnt[i]});
            }
        }
        
        int[] answer = new int[q.size()];
        int size = q.size();
        for (int i = 0; i < size; i++) {
            answer[i] = q.poll()[0];
        }
        
        return answer;
    }
}