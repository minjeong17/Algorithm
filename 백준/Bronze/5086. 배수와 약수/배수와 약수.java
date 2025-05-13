import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String input;
		while (!(input = br.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(input);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a % b == 0) {
				sb.append("multiple\n");
			} else if (b % a == 0) {
				sb.append("factor\n");
			} else {
				sb.append("neither\n");
			}
		}
		
		System.out.println(sb);
	}
}
