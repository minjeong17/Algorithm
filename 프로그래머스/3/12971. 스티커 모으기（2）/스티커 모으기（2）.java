import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = Integer.MIN_VALUE;

        if (sticker.length == 1) return sticker[0];
        else if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        else if (sticker.length == 3) return Math.max(sticker[0] + sticker[2], sticker[1]);
        else {
            int[] dp = new int[sticker.length];
            dp[1] = sticker[1];
            dp[2] = sticker[2] + dp[0];
            for (int i = 3; i < sticker.length; i++) {
                dp[i] = sticker[i] + Math.max(dp[i-2], dp[i-3]);
                answer = Math.max(answer, dp[i]);
            }
            
            int[] dp2 = new int[sticker.length];
            dp2[0] = sticker[0];
            dp2[2] = sticker[2] + dp2[0];
            for (int i = 3; i < sticker.length-1; i++) {
                dp2[i] = sticker[i] + Math.max(dp2[i-2], dp2[i-3]);
                answer = Math.max(answer, dp2[i]);
            }
        }
        
        
        return answer;
    }
}