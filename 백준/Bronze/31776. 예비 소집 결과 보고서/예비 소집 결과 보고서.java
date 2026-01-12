import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            int t3 = Integer.parseInt(st.nextToken());
            
            int tmp = 0;
            if (t1 == -1) tmp++;
            if (t2 == -1) tmp++;
            if (t3 == -1) tmp++;
            
            if (tmp == 3) continue;
            else if (tmp == 2) {
                if (t1 != -1) {
                    answer++;
                    continue;
                }
            } else if (tmp == 1) {
                if (t3 == -1 && t1 <= t2) {
                    answer++;
                    continue;
                }
            } else {
                if (t1 <= t2 && t2 <= t3) {
                    answer++;
                    continue;
                }
            }
        }
        
        System.out.println(answer);
    }
}