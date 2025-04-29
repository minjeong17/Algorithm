import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] coins = {25, 10, 5, 1};
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; t++) {
			
			int C = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < 4; i++) {
				sb.append((C / coins[i]) + " ");
				C %= coins[i];
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
