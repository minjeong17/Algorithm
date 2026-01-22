import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            int cnt = 0;
            for (int i = N; i <= M; i++) {
                cnt += cntZero(i);
            }
            
            ans.append(cnt);
            if (t < T - 1) ans.append("\n");
        }
        
        System.out.println(ans.toString());
    }
    
    public static int cntZero(int n) {
        if (n == 0) return 1;
        
        int count = 0;
        while (n > 0) {
            if (n % 10 == 0) {
                count++;
            }
            n /= 10;
        }
        
        return count;
    }
}