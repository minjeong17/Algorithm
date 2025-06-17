import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()); int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                if ((x1-cx)*(x1-cx) + (y1-cy)*(y1-cy) <= r*r && (x2-cx)*(x2-cx) + (y2-cy)*(y2-cy) <= r*r) continue;
                if ((x1-cx)*(x1-cx) + (y1-cy)*(y1-cy) <= r*r) cnt++;
                if ((x2-cx)*(x2-cx) + (y2-cy)*(y2-cy) <= r*r) cnt++;
            }

            ans.append(cnt).append("\n");
        }

        System.out.println(ans);
    }
}
