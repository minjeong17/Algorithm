import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> map = new HashMap<>();
		
		Map<Character, Integer> alpha = new HashMap<>();
		for (int i = 65; i <= 65+26; i++) {
			alpha.put((char)i, i);
			alpha.put((char)(i+32), i+32);
		}
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String log = st.nextToken();
			
			if (log.equals("enter")) {
				map.put(name, 1);
			} else {
				map.remove(name);
			}
		}
		
		PriorityQueue<String> isIn = new PriorityQueue<>((o1, o2) -> {
			for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
				int o1Num = alpha.get(o1.charAt(i));
				int o2Num = alpha.get(o2.charAt(i));
				if (o1Num != o2Num) {
					return o2Num - o1Num;
				}
			}
			
			return o2.length() - o1.length();
		});
		
		for (String name : map.keySet()) {
			isIn.add(name);
		}
		
		StringBuilder sb = new StringBuilder();
		int size = isIn.size();
		for (int i = 0; i < size; i++) {
			sb.append(isIn.poll() + "\n");
		}
		
		System.out.println(sb);
	}
}
