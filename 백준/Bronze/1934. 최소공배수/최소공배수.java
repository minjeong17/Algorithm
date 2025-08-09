import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int gcd = -1;
            for (int i = Math.min(a, b); i >= 1; i--) {
                if (a % i == 0 && b % i == 0) {
                    gcd = i;
                    break;
                }
            }
            
            int lcm = gcd * (a / gcd) * (b / gcd);
            
            sb.append(lcm).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}