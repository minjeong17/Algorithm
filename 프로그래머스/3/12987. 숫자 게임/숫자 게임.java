import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx = 0;
        for (int i = 0; i < B.length; i++) {
            if (A[aIdx] < B[i]) {
                answer++;
                aIdx++;
            }
        }
        
        
        return answer;
    }
}