import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();
				map.put(type, map.getOrDefault(type, 0) + 1);
			}
			
			
			int ans = 1;
			for (String type : map.keySet()) {
				ans *= (map.get(type) + 1);
			}
			
			System.out.println(ans-1);
		}
	}
}
