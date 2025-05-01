import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = 0;
		Stack<Integer> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			stack.add(i);
			sb.append("+ \n");
			
			if (arr[idx] == i) {
				stack.pop();
				sb.append("- \n");
				idx++;
				while (!stack.isEmpty() &&stack.peek() == arr[idx]) {
					sb.append("- \n");
					stack.pop();
					idx++;
				}
			}
			
			if (i == N && !stack.isEmpty() && stack.peek() != arr[idx]) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println(sb);
 	}
}
