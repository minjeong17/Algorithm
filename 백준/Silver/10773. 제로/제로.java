import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < K; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp == 0) stack.pop();
			else stack.add(tmp);
		}
		
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
		
	}
	
}
