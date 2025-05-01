import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		if (!str.contains("0"))
			System.out.println(-1);
		else {
			char[] arr = str.toCharArray();
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i] - '0';
			}

			if (sum % 3 != 0)
				System.out.println(-1);
			else {
				Arrays.sort(arr);
				StringBuilder sb = new StringBuilder();
				for (int i = arr.length - 1; i >= 0; i--) {
					sb.append(arr[i]);
				}
				System.out.println(sb);
			}
		}

	}
}
