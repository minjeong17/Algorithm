import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	static int C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		long ans = pow(A, B); 
		
		System.out.println(ans);
	}

	private static long pow(long a, long b) {
		
		if (b == 0) return 1;
		
		long tmp = pow(a, b/2);
		long res = (tmp * tmp) % C;
		
		if (b % 2 == 1) {
			res = (res * a) % C;
		}
		
		return res;
	}
}