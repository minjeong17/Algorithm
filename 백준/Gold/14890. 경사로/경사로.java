import java.util.*;
import java.io.*;

public class Main {
    static int N, L;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += check(i, true); // row
            answer += check(i, false); // column
        }
        
        System.out.println(answer);
    }
    
    public static int check(int n, boolean isRow) {
        boolean[] slope = new boolean[N];
            
        for (int i = 1; i < N; i++) {
            int prev = isRow ? map[n][i-1] : map[i-1][n];
            int curr = isRow ? map[n][i] : map[i][n];
            
            if (prev == curr) continue;
            
            if (Math.abs(prev - curr) > 1) return 0;
            
            // 낮은 곳 -> 높은 곳
            if (prev < curr) {
                for (int j = i - L; j < i; j++) {
                    if (j < 0) return 0;
                    
                    int height = isRow ? map[n][j] : map[j][n];
                    
                    if (height != prev || slope[j]) return 0;
                    
                    slope[j] = true;
                }
            } else { // 높은 곳 -> 낮은 곳
                for (int j = i; j < i + L; j++) {
                    if (j >= N) return 0;
                    
                    int height = isRow ? map[n][j] : map[j][n];
                    
                    if (height != curr || slope[j]) return 0;
                    
                    slope[j] = true;
                }
            }
        } 
        
        return 1;
    }
}