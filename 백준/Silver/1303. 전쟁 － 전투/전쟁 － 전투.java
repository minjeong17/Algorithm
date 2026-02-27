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
        
        map = new char[M][N];
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        
        int powerW = 0;
        int powerB = 0;
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int c = cnt(i, j, map[i][j]);
                    if (map[i][j] == 'W') powerW += c * c;
                    else powerB += c * c;
                }    
            }
        }
        
        System.out.println(powerW + " " + powerB);
    }
    
    public static int cnt(int r, int c, char color) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {r, c});
        visited[r][c] = true;
        
        int count = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                
                if (nr < 0 || nr >= M|| nc < 0 || nc >= N) continue;
                if (visited[nr][nc] || map[nr][nc] != color) continue;
                
                visited[nr][nc] = true;
                q.add(new int[] {nr, nc});
                count++;
            }
        }
        
        return count;
    }
}