import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		int last = -1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("push")) {
				last = Integer.parseInt(st.nextToken());
				q.add(last);
			} else if (cmd.equals("pop")) {
				if (q.isEmpty()) sb.append(-1 + "\n");
				else sb.append(q.poll() + "\n");
			} else if (cmd.equals("size")) {
				sb.append(q.size() + "\n");
			} else if (cmd.equals("empty")) {
				if (q.isEmpty()) sb.append(1 + "\n");
				else sb.append(0 + "\n");
			} else if (cmd.equals("front")) {
				if (q.isEmpty()) sb.append(-1 + "\n");
				else sb.append(q.peek() + "\n");
			} else {
				if (q.isEmpty()) sb.append(-1 + "\n");
				else sb.append(last + "\n");
			}
		}
		
		System.out.println(sb);
	}
}
