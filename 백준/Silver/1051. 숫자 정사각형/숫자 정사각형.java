import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] nums = new char[N][M];
        for (int i = 0; i < N; i++) {
            nums[i] = br.readLine().toCharArray();
        }

        int answer = 1;
        for (int len = 1; len <= Math.min(N, M); len++) {
            for (int i = 0; i < N-len; i++) {
                for (int j = 0; j < M-len; j++) {
                    if (nums[i][j] != nums[i][j+len]) continue;
                    else if (nums[i][j] != nums[i+len][j]) continue;
                    else if (nums[i][j] != nums[i+len][j+len]) continue;

                    answer = Math.max(answer, (len+1) * (len+1));
                }
            }
        }

        System.out.println(answer);
    }
}
