import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int ys = 0; int ms = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            ys += (tmp / 30 + 1) * 10;
            ms += (tmp / 60 + 1) * 15;
        }

        if (ys < ms) System.out.println("Y " + ys);
        else if (ys > ms) System.out.println("M " + ms);
        else System.out.println("Y M " + ys);
    }
}
