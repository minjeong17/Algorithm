import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, r, c, ans;
    static boolean found;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        ans = 0; found = false;
        N = (int) Math.pow(2, n);
        cntZ(0, 0, N, 0);

        System.out.println(ans);
    }

    private static void cntZ(int startR, int startC, int n, int cnt) {

        if (found) return;

        if (n == 1) {
            if (startR == r && startC == c) {
                ans = cnt;
            }
            return;
        }

        if (startR > r || startR + n <= r || startC > c || startC + n <= c) return;

        int newN = n / 2;

        cntZ(startR, startC, newN, cnt);
        cntZ(startR, startC+newN, newN, cnt+newN*newN);
        cntZ(startR+newN, startC, newN, cnt+2*newN*newN);
        cntZ(startR+newN, startC+newN, newN, cnt+3*newN*newN);
    }
}
