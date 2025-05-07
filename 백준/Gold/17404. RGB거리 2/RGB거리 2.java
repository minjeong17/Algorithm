import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] colors = new int[N+1][3];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				colors[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// System.out.println(Arrays.deepToString(colors));
		
		int res = Integer.MAX_VALUE;
		int[][] dp = new int[N+1][3];
		for (int i = 0; i < 3; i++) {
			Arrays.fill(dp[1], 100000);
			dp[1][i] = colors[1][i];
			
			for (int j = 2; j < N; j++) {
				dp[j][0] = colors[j][0] + Math.min(dp[j-1][1], dp[j-1][2]);
				dp[j][1] = colors[j][1] + Math.min(dp[j-1][0], dp[j-1][2]);
				dp[j][2] = colors[j][2] + Math.min(dp[j-1][1], dp[j-1][0]);
			}
			
//			System.out.println(Arrays.deepToString(dp));
			
			for (int k = 0; k < 3; k++) {
				if (i == k) continue;
//				dp[N][k] = colors[N][k] + Math.min(dp[N-1][(k+1)%3], dp[N-1][(k+2)%3]);
				res = Math.min(res, colors[N][k] + Math.min(dp[N-1][(k+1)%3], dp[N-1][(k+2)%3]));
			}
		}
		
		System.out.println(res);
		
	}
}