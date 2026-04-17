import java.io.*;
import java.util.*;

public class Main {
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static int N, L, R;
    public static int[][] people;
    public static boolean[][] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        people = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                people[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        while (true) {
            boolean flag = false;
            visited = new boolean[N][N];
            
            List<List<int[]>> unions = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    
                    List<int[]> list = check(i, j); // 마지막 값[0] -> 인구수
                    
                    if (list.size() > 2) { // 연합 생김 (좌표 2개 이상 + 마지막 total)
                        unions.add(list);
                        flag = true;
                    }
                }
            }
            
            if (!flag) break;
            
            for (List<int[]> list : unions) {
                int size = list.size();
                int t = list.get(size - 1)[0];
                
                for (int k = 0; k < size - 1; k++) {
                    people[list.get(k)[0]][list.get(k)[1]] = t / (size - 1);
                }
            }
            
            answer++;
        }
        
        System.out.println(answer);
    }
    
    public static List<int[]> check(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {i, j});
        visited[i][j] = true;
        
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {i, j});
        
        int total = people[i][j];
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                
                int diff = Math.abs(people[curr[0]][curr[1]] - people[nr][nc]);
                if (diff >= L && diff <= R) {
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                    list.add(new int[] {nr, nc});
                    total += people[nr][nc];
                }
            }
        }
        
        list.add(new int[] {total, 0});
        
        return list;
    }
}