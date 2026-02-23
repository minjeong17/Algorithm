import java.io.*;
import java.util.*;

public class Main {
    
    static int L, W;
    static char[][] map;
    static int answer;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        
        map = new char[L][W];
        for (int i = 0; i < L; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        answer = Integer.MIN_VALUE;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'L') {
                    find(i, j);
                }
            }
        }     
        
        System.out.println(answer-1);
    }
    
    public static void find(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[L][W];
        
        q.add(new int[] {r, c});
        visited[r][c] = true;
        
        int len = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    
                    if (nr < 0 || nr >= L || nc < 0 || nc >= W) continue;
                    if (map[nr][nc] == 'W' || visited[nr][nc]) continue;
                    
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
            
            len++;
        }
        
        answer = Math.max(answer, len);
    }
}