import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            map[r-1][c-1] = '#';
        }
        
        int answer = Integer.MIN_VALUE;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '#' && !visited[i][j]) {
                    answer = Math.max(answer, find(i, j));
                }
            }
        }
        
        System.out.println(answer);
    }
    
    public static int find(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {r, c});
        visited[r][c] = true;
        
        int ans = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc] || map[nr][nc] != '#') continue;
                
                visited[nr][nc] = true;
		q.add(new int[] {nr, nc});
                ans++;
            }
        }
        
        return ans;
    }
}