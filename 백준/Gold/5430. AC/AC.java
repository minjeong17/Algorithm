import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		outer:for (int t = 0; t < T; t++) {
			
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();
			String[] arr = input.substring(1, input.length()-1).split(",");
//			System.out.println(Arrays.toString(arr));
			
//			List<String> list = new ArrayList<>();

//			if (n != 0) list = new ArrayList<>(Arrays.asList(arr));
			
			boolean flag = true; // true면 순서대로, false면 역순
			int start = 0;
			int end = n-1;
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == 'R') {
//					Collections.reverse(list);
					flag = !flag;
				}
				else {
					if (start > end) {
						System.out.println("error");
						continue outer;
					} else {
//						list.remove(0);
						if (flag) start++;
						else end--;
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			if (flag) {
				for (int i = start; i <= end; i++) {
					if (i == end) sb.append(arr[i]);
					else sb.append(arr[i]+",");
				}
				sb.append("]");
			} else {
				for (int i = end; i >= start; i--) {
					if (i == start) sb.append(arr[i]);
					else sb.append(arr[i]+",");
				}
				sb.append("]");
				
			}
			
			System.out.println(sb);
		}
	}
}
