import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		String[] oper = input.split("-");
		
		int[] tmp = new int[oper.length];
		int idx = 0;
		for (String str : oper) {
			if (str.contains("+")) {
				String[] s = str.split("\\+");
				int t = 0;
				for (String ss : s) {
					t += Integer.parseInt(ss);
				}
				tmp[idx++] = t;
			} else {
				tmp[idx++] = Integer.parseInt(str);
			}
		}
		
		int ans = tmp[0];
		for (int i = 1; i < tmp.length; i++) {
			ans -= tmp[i];
		}
		
		System.out.println(ans);
		
	}
}
