import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder ans = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            if (N <= 3) {
                ans.append(N).append("\n");
            } else {
                int[] dp = new int[N+1];
                dp[1] = 1; dp[2] = 2; dp[3] = 2;
            
                int[] dp3 = new int[N+1];
                dp3[1] = 0; dp3[2] = 0; dp3[3] = 1;
            
                for (int i = 4; i <= N; i++) {
                    int sum = dp[i-2] + dp[i-1];
                    if (sum % 2 == 0) {
                        dp[i] = sum - (sum/2 - 1);
                    } else {
                        dp[i] = sum - sum/2;
                    }
                    dp3[i] = dp[i-3] + dp3[i-3];
                }
                
                ans.append(dp[N] + dp3[N]).append("\n");
            }
        }
        
        System.out.println(ans.toString());
    }
}