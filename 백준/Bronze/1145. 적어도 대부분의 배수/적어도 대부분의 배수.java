import java.io.*;
import java.util.*;

class Main {

    static int[] nums = new int[5];
    static int[] sel = new int[3];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0);
        System.out.println(ans);
    }

    static void comb(int idx, int sidx) {
        if (sidx == 3) {
            long l = lcm(lcm(sel[0], sel[1]), sel[2]);
            ans = Math.min(ans, (int) l);
            return;
        }
        for (int i = idx; i < 5; i++) {
            sel[sidx] = nums[i];
            comb(i + 1, sidx + 1);
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a / gcd((int) a, (int) b) * b;
    }
}
