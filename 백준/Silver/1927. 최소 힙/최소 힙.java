import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			int cmd = Integer.parseInt(br.readLine());
			if (cmd == 0) {
				if (pq.isEmpty()) sb.append(0 + "\n");
				else sb.append(pq.poll() + "\n");
			} else {
				pq.add(cmd);
			}
		}
		
		System.out.println(sb);
	}
}
