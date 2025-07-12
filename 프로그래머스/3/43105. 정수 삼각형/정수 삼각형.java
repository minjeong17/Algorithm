import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int[][] dp = triangle;
        
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = triangle[i][0] + dp[i-1][0];
            
            int len = dp[i].length;
            for (int j = 1; j < len-1; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
            
            dp[i][len-1] = triangle[i][len-1] + dp[i-1][len-2];
        }
        
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < dp[dp.length-1].length; i++) {
            answer = Math.max(answer, dp[dp.length-1][i]);
        }
        
        return answer; 
    }
}