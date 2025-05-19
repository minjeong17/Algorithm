import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		while (!(input = br.readLine()).equals("0 0 0")) {
			
			int[] nums = new int[3];
			StringTokenizer st = new StringTokenizer(input);
			for (int i = 0; i < 3; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			int a = nums[0]; int b = nums[1]; int c = nums[2];
			
			if (a + b <= c) {
				System.out.println("Invalid");
				continue;
			} else if (a == b && b == c && c == a) {
				System.out.println("Equilateral");
				continue;
			} else if (a == b || b == c || c == a) {
				System.out.println("Isosceles");
				continue;
			} else {
				System.out.println("Scalene");
				continue;
			}
			
		}
	}
}
