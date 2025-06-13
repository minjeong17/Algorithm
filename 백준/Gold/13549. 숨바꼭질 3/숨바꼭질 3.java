import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(N));
	}

	static int bfs(int n) {
		Queue<int[]> q = new LinkedList<>();
		int[] visited = new int[100000+1];
		Arrays.fill(visited, Integer.MAX_VALUE);
		
		q.add(new int[] {n, 0});
		visited[n] = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();

			if (visited[K] != Integer.MAX_VALUE) {
				return visited[K];
			}

			for (int i = 0; i < size; i++) {

				int[] curr = q.poll();

				int loc = curr[0];
				int sec = curr[1];

				if (loc * 2 <= 100000 && visited[loc*2] > sec) {
					visited[loc*2] = sec;
					q.add(new int[] {loc*2, sec});
				}
				if (loc + 1 <= 100000 && visited[loc+1] > sec+1) {
					visited[loc+1] = sec+1;
					q.add(new int[] {loc+1, sec+1});
				}
				if (loc - 1 >= 0 && visited[loc-1] > sec+1) {
					visited[loc-1] = sec+1;
					q.add(new int[] {loc-1, sec+1});
				}
			}
		}
		return -1;
	}
}
