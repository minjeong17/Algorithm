import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tmp = -1;
		
		for (int i = 3; i > 0; i--) {
			String input = br.readLine();
			if (isNumber(input)) {
				tmp = Integer.parseInt(input) + i;
				break;
			}
		}
		
		if (tmp % 3 == 0 && tmp % 5 == 0) System.out.println("FizzBuzz");
		else if (tmp % 3 == 0 && tmp % 5 != 0) System.out.println("Fizz");
		else if (tmp % 3 != 0 && tmp % 5 == 0) System.out.println("Buzz");
		else System.out.println(tmp);
	}

	private static boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
