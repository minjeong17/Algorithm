import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, ans;
	static char[][] map;
	static Queue<int[]> q;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		q = new LinkedList<>();
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'I') {
					q.add(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		
		ans = 0;
		bfs();
		if (ans == 0) System.out.println("TT");
		else System.out.println(ans);
	}
	private static void bfs() {
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if (visited[nr][nc] || map[nr][nc] == 'X') continue;
				
				if (map[nr][nc] == 'P') ans++;
				q.add(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
			
		}
		
	}
}
