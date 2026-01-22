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
            
            if (N < 12 || M < 4) {
                ans.append(-1);
            } else {
                ans.append(M * 11 + 4);
            }
            
            if (t < T - 1) ans.append("\n");
        }
        
        System.out.println(ans.toString());
    }
}