import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        char[][] map = new char[R][C];
        int jR = 0; int jC = 0;
        Queue<int[]> fires = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
                
                if (map[i][j] == 'J') {
                    jR = i;
                    jC = j;
                } else if (map[i][j] == 'F') fires.add(new int[] {i, j});
            }
        }
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        q.add(new int[] {jR, jC});
        visited[jR][jC] = true;
        
        int answer = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            // 불 번지기
            int fireSize = fires.size();
            for (int i = 0; i < fireSize; i++) {
                int[] currF = fires.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nr = currF[0] + dr[d];
                    int nc = currF[1] + dc[d];
                    
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    if (map[nr][nc] == '#' || map[nr][nc] == 'F') continue;
                    
                    map[nr][nc] = 'F';
                    fires.add(new int[] {nr, nc});
                }
            }
            
            for (int i = 0; i < size; i++) {
                // 지훈 이동하기
                int[] curr = q.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                        System.out.println(answer + 1);
                        return;
                    }
                    if (visited[nr][nc] || map[nr][nc] == 'F' || map[nr][nc] == '#') continue;

                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
            
            answer++;
        }        
        
        System.out.println("IMPOSSIBLE");
    }
}