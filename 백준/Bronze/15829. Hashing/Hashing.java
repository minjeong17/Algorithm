import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		BigInteger res = new BigInteger("0");
		for (int i = 0; i < N; i++) {
			res = res.add(BigInteger.valueOf(str.charAt(i)-96)
					 .multiply(BigInteger.valueOf(31).pow(i)));
		}
		
		System.out.println(res.remainder(BigInteger.valueOf(1234567891)));
	}
}