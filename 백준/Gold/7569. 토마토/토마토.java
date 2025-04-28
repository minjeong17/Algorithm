import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M, N, H, cnt;
	static int[][][] box;
	static Queue<int[]> q;
	static boolean[][][] visited;
	
	static int[] di = {-1, 1, 0, 0, 0, 0};
	static int[] dj = {0, 0, -1, 1, 0, 0};
	static int[] dk = {0, 0, 0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[N][M][H];
		q = new LinkedList<>();
		visited = new boolean[N][M][H];
		
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) {
						q.add(new int[] {i, j, k});
						visited[i][j][k] = true;
					}
				}
			}
		}
		
		if (q.size() == N*M*H) System.out.println(0);
		else {
			bfs();
			boolean flag = true;
			outer:for (int k = 0; k < H; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (box[i][j][k] == 0) {
							flag = false;
						}
					}
				}
			}
			
			if (flag) System.out.println(cnt-1);
			else System.out.println(-1);
		}
		
	}

	private static void bfs() {
		
		cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int s = 0; s < size; s++) {
				int[] curr = q.poll();
				
				for (int d = 0; d < 6; d++) {
					int ni = curr[0] + di[d];
					int nj = curr[1] + dj[d];
					int nk = curr[2] + dk[d];
					
					if (ni < 0 || ni >= N || nj < 0 || nj >= M || nk < 0 || nk >= H) continue;
					if (box[ni][nj][nk] != 0 || visited[ni][nj][nk] == true) continue;
					
					visited[ni][nj][nk] = true;
					q.add(new int[] {ni, nj, nk});
					box[ni][nj][nk] = 1;
					
					
				}
			}
			
			cnt++;
		}
		
	}
}
