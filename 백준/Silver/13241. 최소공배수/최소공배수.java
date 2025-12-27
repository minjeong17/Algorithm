import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long tmpA = A;
        long tmpB = B;

        if (A < B) {
            long tmp = B;
            B = A;
            A = tmp;
        }

        long answer = 0L;
        while (true) {
            if (A % B == 0) {
                answer = B;
                break;
            }

            long t = A % B;
            A = B;
            B = t;
        }

        System.out.println(tmpA * tmpB / answer);
    }
}
