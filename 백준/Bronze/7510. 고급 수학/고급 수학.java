import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            ans.append("Scenario #").append(i).append(":\n");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] len = new int[3];
            len[0] = Integer.parseInt(st.nextToken());
            len[1] = Integer.parseInt(st.nextToken());
            len[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(len);

            if (len[2]*len[2] == len[0]*len[0] + len[1]*len[1]) ans.append("yes\n");
            else ans.append("no\n");

            ans.append("\n");
        }

        System.out.println(ans);
    }
}
