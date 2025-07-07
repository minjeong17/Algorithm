class Solution {
    public long solution(int n) {
        
        if (n == 1) return 1;
        else if (n == 2) return 2;
        
        long[] dp = new long[n+1];
        for (int i = 1; i <= 2; i++) dp[i] = i;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] % 1234567 + dp[i-2] % 1234567;
        }
        
        
        return dp[n] % 1234567;
    }
}