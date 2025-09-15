import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minSet = Integer.MAX_VALUE;
        int minItem = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            minSet = Math.min(minSet, Integer.parseInt(st.nextToken()));
            minItem = Math.min(minItem, Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        while (N >= 6) {
            if (minItem * 6 < minSet) {
                ans += minItem * 6;
            } else {
                ans += minSet;
            }

            N -= 6;
        }

        if (minItem * N < minSet) {
            ans += minItem * N;
        } else {
            ans += minSet;
        }

        System.out.println(ans);
    }
}
