import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int t = 1;
		while (cnt < N) {
			if (((t++)+"").contains("666")) cnt++;
		}
		
		System.out.println(t-1);
	}
}
