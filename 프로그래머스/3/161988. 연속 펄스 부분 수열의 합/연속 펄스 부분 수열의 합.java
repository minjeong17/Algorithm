import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int len = sequence.length;
        
        int[] seq1 = new int[len];
        int[] seq2 = new int[len];
        int m = -1;
        for (int i = 0; i < len; i++) {
            seq1[i] = sequence[i] * m;
            seq2[i] = sequence[i] * m * (-1);
            
            m *= -1;
        }
        
        long[] dp1 = new long[len];
        long[] dp2 = new long[len];
        long answer = Math.max(seq1[0], seq2[0]);
        dp1[0] = seq1[0]; dp2[0] = seq2[0];
        for (int i = 1; i < len; i++) {
            if (dp1[i-1] >= 0) dp1[i] = dp1[i-1] + seq1[i];
            else dp1[i] = seq1[i];
            
            if (dp2[i-1] >= 0) dp2[i] = dp2[i-1] + seq2[i];
            else dp2[i] = seq2[i];
            
            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));
        }
        
        return answer;
    }
}