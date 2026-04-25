import java.io.*;
import java.util.*;

public class Main {
    public static int cnt;
    public static StringBuilder ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        cnt = 0;
        ans = new StringBuilder();
        hanoi(N, 1, 3, 2);
        
        System.out.println(cnt);
        System.out.println(ans.toString());
    }
    
    public static void hanoi(int N, int start, int end, int sub) {
        if (N == 1) {
            ans.append(start).append(" ").append(end).append("\n");
            cnt++;
            return;
        }
        
        hanoi(N-1, start, sub, end);
        ans.append(start).append(" ").append(end).append("\n");
        cnt++;
        hanoi(N-1, sub, end, start);
    }
}