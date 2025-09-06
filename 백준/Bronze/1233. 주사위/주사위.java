import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());
        
        int[] sums = new int[num1+num2+num3+1];
        for (int i = 1; i <= num1; i++) {
            for (int j = 1; j <= num2; j++) {
                for (int k = 1; k <= num3; k++) {
                    sums[i + j + k]++;
                }
            }
        }
        
        int ans = 0;
        for (int i = 3; i <= num1+num2+num3; i++) {
            if (sums[i] > sums[ans]) ans = i;
        }
        
        System.out.println(ans);
    }
}