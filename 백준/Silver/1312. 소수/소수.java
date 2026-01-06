import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int d = A / B;
        A = (A - B * d) * 10;

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = A / B;
            A = (A - B * answer) * 10;
        }

        System.out.println(answer);
    }
}
