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
        
        map = new char[N][M];
        int cntS = 0;
        int cntW = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'o') cntS++;
                else if (map[i][j] == 'v') cntW++;
            }
        }
        
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((map[i][j] == 'o' || map[i][j] == 'v') && !visited[i][j]) {
                    int[] c = count(i, j);
                    if (c[0] > c[1]) {
                        cntW -= c[1];
                    } else {
                        cntS -= c[0];
                    }
                }
            }
        }
        
        System.out.println(cntS + " " + cntW);
    }
    
    public static int[] count(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        int tmpS = 0;
        int tmpW = 0;
        
        q.add(new int[] {r, c});
        visited[r][c] = true;
        if (map[r][c] == 'o') tmpS++;
        else if (map[r][c] == 'v') tmpW++;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc] || map[nr][nc] == '#') continue;
                
                if (map[nr][nc] == 'o') tmpS++;
                else if (map[nr][nc] == 'v') tmpW++;
                visited[nr][nc] = true;
                q.add(new int[] {nr, nc});
            }
        }
        
        return new int[] {tmpS, tmpW};
    }
}