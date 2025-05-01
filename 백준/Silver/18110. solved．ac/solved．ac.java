import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int p = (int) Math.round(n * 0.15);
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int sum = 0;
		for (int i = p; i < (n-p); i++) {
			sum += arr[i];
		}
		
		int ans = (int) Math.round((double)sum/(n-(p*2)));
		System.out.println(ans);
	}
}
