import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			
			int k = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				if (cmd.equals("I")) {
					map.put(n, map.getOrDefault(n, 0)+1);
				} else {
					if (map.isEmpty()) continue;
					if (n == 1) {
						int max = map.lastKey();
						if (map.get(max) == 1) map.remove(max);
						else map.put(max, map.get(max)-1);
					} else {
						int min = map.firstKey();
						if (map.get(min) == 1) map.remove(min);
						else map.put(min, map.get(min)-1);
					}
				}
			}
			
			if (map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey() + " " + map.firstKey() + "\n");
			}
			
		}
		System.out.println(sb);
	}
}
