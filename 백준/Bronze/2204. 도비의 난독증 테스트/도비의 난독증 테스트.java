import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<Character, Integer> alpha = new HashMap<>();
		for (int i = 65; i <= 65+26; i++) {
			alpha.put((char)i, i-65);
			alpha.put((char)(i+32), i+32-97);
		}
		
		int N;
		StringBuilder sb = new StringBuilder();
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
				for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
					int o1Num = alpha.get(o1.charAt(i));
					int o2Num = alpha.get(o2.charAt(i));
					
					if (o1Num != o2Num) return o1Num - o2Num;
				}
				
				return o1.length() - o2.length();
			});
			
			for (int i = 0; i < N; i++) {
				pq.add(br.readLine());
			}
			
			sb.append(pq.poll() + "\n");
		}	
		
		System.out.println(sb);
	}
}
