import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C;
	static char[][] map;
	
	static List<int[]> fireList;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		int[] loc = new int[2];
		fireList = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'J') loc = new int[] {i, j};
				else if (map[i][j] == 'F') {
					fireList.add(new int[] {i, j});
				}
			}
		}
		
//		dr.add(-1); dr.add(1); dr.add(0); dr.add(0);
//		dc.add(0); dc.add(0); dc.add(-1); dc.add(1);
		
		int ans = bfs(loc);
		
		System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
	}

	private static int bfs(int[] loc) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];

		q.add(loc);
		visited[loc[0]][loc[1]] = true;

		Queue<int[]> fireQ = new LinkedList<>();
		boolean[][] fireVisited = new boolean[R][C];
		
		for (int[] n : fireList) {
			fireQ.add(n);
			fireVisited[n[0]][n[1]] = true;
		}
		
		int cnt = 1;
		while (!q.isEmpty()) {
			int fireSize = fireQ.size();
			for (int i = 0; i < fireSize; i++) {
				int[] curr = fireQ.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];
					
					if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					if (fireVisited[nr][nc] || map[nr][nc] == '#') continue;
					
					fireVisited[nr][nc] = true;
					map[nr][nc] = 'F';
					fireQ.add(new int[] {nr, nc});
					
				}
			}
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] curr = q.poll();
				
				if ((curr[0] == 0 || curr[0] == R-1) 
					|| (curr[1] == 0 || curr[1] == C-1)) return cnt;
				
				
				for (int d = 0; d < 4; d++) {
					int nr = curr[0] + dr[d];
					int nc = curr[1] + dc[d];
					
					if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					if (visited[nr][nc] || map[nr][nc] != '.') continue;
					
					visited[nr][nc] = true;
					q.add(new int[] {nr, nc});
				}
			}
			cnt++;
		}
		
		return -1;
	}
}
