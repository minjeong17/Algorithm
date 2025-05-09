import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) q.add(i);
		
		int cnt = 1;
		while (!q.isEmpty()) {
			if (cnt == K) {
				sb.append(q.poll());
				if (!q.isEmpty()) sb.append(", "); 
				cnt = 1;
			} else {
				q.add(q.poll());
				cnt++;
			}
				
		}
		
		sb.append(">");
		System.out.println(sb);
	}
}
