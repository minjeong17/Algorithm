import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		while (!(input = br.readLine()).equals(".")) {
			
			Stack<Character> stack = new Stack<>();
			
			String ans = "yes";
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(' || input.charAt(i) == '[') 
					stack.add(input.charAt(i));
				else if (input.charAt(i) == ')') {
					if (stack.isEmpty() || stack.pop() != '(') {
						ans = "no";
						break;
					}
				} else if (input.charAt(i) == ']') {
					if (stack.isEmpty() || stack.pop() != '[') {
						ans = "no";
						break;
					}
				}
			}
			
			if (stack.isEmpty()) System.out.println(ans);
			else System.out.println("no");
		}
		
	}
}
