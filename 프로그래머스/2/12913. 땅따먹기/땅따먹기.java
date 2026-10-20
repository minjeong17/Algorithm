import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int N = land.length;
        int[][] score = new int[N][4];
        for (int i = 0; i < 4; i++) {
            score[0][i] = land[0][i];
        }
        
        for (int i = 1; i < N; i++) {
            score[i][0] = land[i][0] + Math.max(score[i-1][1], Math.max(score[i-1][2], score[i-1][3]));
            score[i][1] = land[i][1] + Math.max(score[i-1][0], Math.max(score[i-1][2], score[i-1][3]));
            score[i][2] = land[i][2] + Math.max(score[i-1][0], Math.max(score[i-1][1], score[i-1][3]));
            score[i][3] = land[i][3] + Math.max(score[i-1][0], Math.max(score[i-1][1], score[i-1][2]));
        }
        
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, score[N-1][i]);
        }
        
        return answer;
    }
}