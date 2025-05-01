import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int cnt0 = 0;
		int cnt1 = 0;
		
		char tmp = str.charAt(0);
		if (tmp == '0') cnt0++;
		else cnt1++;
		
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != tmp) {
				if (str.charAt(i) == '0') cnt0++;
				else cnt1++;
				tmp = str.charAt(i);
			}
		} 
		
		System.out.println(Math.min(cnt0, cnt1));
	}
}
