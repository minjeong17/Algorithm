import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][10];
		
		if (N == 1) System.out.println(10);
		else {
			Arrays.fill(dp[1], 1);
			for (int i = 2; i <= N; i++) {
				for (int j = 0; j < 10; j++) {
					for (int k = j; k < 10; k++) {
						dp[i][j] += (dp[i-1][k] % 10007);
					}
				}
			}
			
			int ans = 0;
			for (int i = 0; i < 10; i++) {
				ans += (dp[N][i] % 10007);
			}
			
			System.out.println(ans % 10007);
		}
		
	}
}
