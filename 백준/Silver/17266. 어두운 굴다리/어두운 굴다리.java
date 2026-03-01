import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] lamps = new int[M];
        for (int i = 0; i < M; i++) {
            lamps[i] = Integer.parseInt(st.nextToken());
        }
        
        int tmp = Integer.MIN_VALUE;
        for (int i = 0; i < M - 1; i++) {
            tmp = Math.max(tmp, (lamps[i+1] - lamps[i] + 1) / 2);
        }
        
        int answer = Math.max(Math.max(tmp, lamps[0]), N - lamps[M-1]);
        
        System.out.println(answer);
    }
}