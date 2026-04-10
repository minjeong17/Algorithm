import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][][] dp = new int[N][M][3];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = map[0][i];
            }
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    dp[i][j][0] = map[i][j] + Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]);
                    dp[i][j][1] = map[i][j] + dp[i-1][j][0];
                } else if (j == M - 1) {
                    dp[i][j][1] = map[i][j] + dp[i-1][j][2];
                    dp[i][j][2] = map[i][j] + Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]);
                } else {
                    dp[i][j][0] = map[i][j] + Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]);;
                    dp[i][j][1] = map[i][j] + Math.min(dp[i-1][j][0], dp[i-1][j][2]);
                    dp[i][j][2] = map[i][j] + Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]);
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                if (dp[N-1][i][j] != 0) answer = Math.min(answer, dp[N-1][i][j]);
            }
        }
        
        System.out.println(answer);
    }
}