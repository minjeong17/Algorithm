import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if (N % 10 != 0) {
			System.out.println(-1);
		} else {
			int[] times = {300, 60, 10};
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 3; i++) {
				sb.append(N / times[i] + " ");
				N %= times[i];
			}
			
			System.out.println(sb);
		}
	}
}
