import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] pos;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        pos = new int[N];
        st = new StringTokenizer(br.readLine());
        int cntNegative = 0;
        for (int i = 0; i < N; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
            if (pos[i] < 0) cntNegative++;
        }
        
        Arrays.sort(pos);

        if (M == 1) {
            int answer = 0;
            for (int n : pos) {
                answer += Math.abs(n) * 2;
            }

            if (Math.abs(pos[0]) < Math.abs(pos[N-1])) answer -= Math.abs(pos[N-1]);
            else answer -= Math.abs(pos[0]);

            System.out.println(answer);
            return;
        }

        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < cntNegative; i++) {
            if (cnt % M == 0) {
                answer += Math.abs(pos[i]) * 2;
            }
        
            cnt++;
        }
        
        cnt = 0;
        for (int i = N - 1; i >= cntNegative; i--) {
            if (cnt % M == 0) {
                answer += Math.abs(pos[i]) * 2;
            }
        
            cnt++;
        }

        if (Math.abs(pos[0]) < Math.abs(pos[N-1])) answer -= Math.abs(pos[N-1]);
        else answer -= Math.abs(pos[0]);
        
        System.out.println(answer);
    }
} 