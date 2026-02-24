import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] t = new int[3];
        int[][] m = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            
            m[i][0] = Integer.parseInt(st.nextToken());
            m[i][1] = Integer.parseInt(st.nextToken());
            m[i][2] = Integer.parseInt(st.nextToken());
            
            if (num == K) {
                t[0] = m[i][0];
                t[1] = m[i][1];
                t[2] = m[i][2];
            }
        }
        
        Arrays.sort(m, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) return o2[2] - o1[2];
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });
        
        int answer = -1;
        for (int i = 0; i < N; i++) {
            if (m[i][0] == t[0] && m[i][1] == t[1] && m[i][2] == t[2]) {
                answer = i + 1;
                break;
            }
        }
        
        System.out.println(answer);
    }
}