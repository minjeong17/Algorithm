import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] ans = new int[4];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int grade = Integer.parseInt(st.nextToken());
            int room = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (grade == 1) ans[3]++;
            else {
                if (room == 1 || room == 2) ans[0]++;
                else if (room == 3) ans[1]++;
                else ans[2]++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(ans[i]).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}