import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] coins = {500, 100, 50, 10, 5, 1};
		
		int ex = 1000 - Integer.parseInt(br.readLine());
		
		int ans = 0;
		for (int i = 0; i < 6; i++) {
			ans += ex / coins[i];
			ex %= coins[i];
		}
		
		System.out.println(ans);
		
	}
}
