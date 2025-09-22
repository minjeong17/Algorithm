import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] dp = new int[B+1];
        dp[1] = 1;
        int num = 1;
        int cnt = 1;
        for (int i = 2; i <= B; i++) {
            if (num == cnt) {
                num++;
                cnt = 0;
            }
            dp[i] = dp[i-1] + num;
            cnt++;
        }

        System.out.println(dp[B] - dp[A-1]);
    }
}
