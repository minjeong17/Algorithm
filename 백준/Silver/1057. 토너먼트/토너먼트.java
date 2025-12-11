import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int answer = 0;
        while (J != H) {
            J = (J + 1) / 2;
            H = (H + 1) / 2;
            answer++;
        }

        System.out.println(answer);
    }
}
