import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		
		long sum = 0;
		long i = 1;
		while (sum <= N) {
			sum += i++;
		}
		
		System.out.println(i-2);
	}
}
