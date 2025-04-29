import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] roads = new long[N-1];
		long[] prices = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			roads[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			prices[i] = Long.parseLong(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(roads));
//		System.out.println(Arrays.toString(prices));
		
		long sum = 0;
		long tmp = prices[0];
		for (int i = 0; i < N-1; i++) {
			if (prices[i] <= tmp) {
				sum += prices[i] * roads[i];
				tmp = prices[i];
			} else {
				sum += tmp * roads[i];
			}
//			System.out.println(i + " " + sum);
		}
		
		System.out.println(sum);
	}
}
