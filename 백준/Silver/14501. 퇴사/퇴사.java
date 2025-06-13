import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

//		System.out.println(Arrays.deepToString(arr));

		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			if (i + arr[i][0] <= N+1) {
				dp[i] += arr[i][1];
			}
			int nextIdx = i+arr[i][0];
			for (int j = nextIdx; j <= N; j++) {
				dp[j] = Math.max(dp[i], dp[j]);
			}
		}

//		System.out.println(Arrays.toString(dp));

		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			ans = Integer.max(ans, dp[i]);
		}

		System.out.println(ans);
	}
}

