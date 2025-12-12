import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] size = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }
        int C = Integer.parseInt(br.readLine());

        long answer = 0;
        for (int s : size) {
            int tmp = (int) Math.ceil((double) s / C);
            answer += C * tmp;
        }

        System.out.println(answer);
    }
}
