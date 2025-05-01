import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		outer:for (int i = 0; i < N; i++) {
			String input = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == '(') stack.push('(');
				else {
					if (stack.isEmpty() || stack.pop() != '(') {
						sb.append("NO" + "\n");
						continue outer;
					}
				}
			}
			if (stack.isEmpty()) sb.append("YES" + "\n");
			else sb.append("NO" + "\n");
			
		}
		
		System.out.println(sb);
	}
}
