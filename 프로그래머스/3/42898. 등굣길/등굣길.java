import java.util.*;

class Solution {
    
    public long solution(int m, int n, int[][] puddles) {
        
        int[][] map = new int[n+1][m+1];
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = 1;
        }
        
        long[][] dp = new long[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            if (map[i][1] == 1) break;
            dp[i][1] = 1;
        }
        for (int i = 1; i <= m; i++) {
            if (map[1][i] == 1) break;
            dp[1][i] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (map[i][j] == 0) {
                    dp[i][j] = (dp[i-1][j] % 1000000007) + (dp[i][j-1] % 1000000007);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[n][m] % 1000000007;
    }
}