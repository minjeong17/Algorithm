import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] std = new int[N];
        for (int i = 0; i < N; i++) {
            std[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < N-1; j++) {
                if (std[j] % i > std[j+1] % i) {
                    int tmp = std[j];
                    std[j] = std[j+1];
                    std[j+1] = tmp;
                }
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N-1; i++) {
            ans.append(std[i]).append("\n");
        }
        ans.append(std[N-1]);
        
        System.out.println(ans.toString());
    }
}