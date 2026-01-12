import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int curr = 0;
        int maxSize = S;
        for (int i = 0; i < N+M; i++) {
            int cmd = Integer.parseInt(br.readLine());
            
            if (cmd == 1) {
                if (curr == maxSize) maxSize *= 2;
                curr++;
            } else {
                curr--;
            }
        }
        
        System.out.println(maxSize);
    }
}