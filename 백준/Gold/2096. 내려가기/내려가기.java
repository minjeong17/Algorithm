import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][][] dp = new int[N+1][3][2];  // 0 : 최대, 1 : 최소
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0]) + a;
			dp[i][0][1] = Math.min(dp[i-1][0][1], dp[i-1][1][1]) + a;
			
			int b = Integer.parseInt(st.nextToken());
			dp[i][1][0] = Math.max(dp[i-1][2][0], Math.max(dp[i-1][0][0], dp[i-1][1][0])) + b;
			dp[i][1][1] = Math.min(dp[i-1][2][1], Math.min(dp[i-1][0][1], dp[i-1][1][1])) + b;

			int c = Integer.parseInt(st.nextToken());
			dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][1][0]) + c;
			dp[i][2][1] = Math.min(dp[i-1][2][1], dp[i-1][1][1]) + c;
			
		}
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, dp[N][i][0]);
			min = Math.min(min, dp[N][i][1]);
		}
		
		System.out.println(max + " " + min);
		
	}
}
