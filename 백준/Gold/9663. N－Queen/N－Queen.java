import java.io.*;
import java.util.*;

public class Main {
    public static int ans;
    public static int[] queen;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        queen = new int[N];
        ans = 0;
        dfs(0, N);
        
        System.out.println(ans);
    }
    
    public static void dfs(int row, int N) {
        if (row == N) {
            ans++;
            return;
        }
        
        for (int j = 0; j < N; j++) {
            if (check(row, j)) {
                queen[row] = j;
                dfs(row + 1, N);
            }
        }
    }
    
    public static boolean check(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queen[i] == col) return false;
            if (Math.abs(i - row) == Math.abs(queen[i] - col)) return false;
        }
        
        return true;
    }
}