import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int diag = W*W + H*H;

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {

            int len = Integer.parseInt(br.readLine());

            if (len * len <= diag) ans.append("DA").append("\n");
            else ans.append("NE").append("\n");
        }

        System.out.println(ans);
    }
}
