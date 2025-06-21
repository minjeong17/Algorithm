import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        StringBuilder Pn = new StringBuilder();
        Pn.append("I");
        for (int i = 0; i < N; i++) {
            Pn.append("OI");
        }
        int len = 2 * N + 1;

        int ans = 0;
        for (int i = 0; i < M-len+1; i++) {
            boolean isOk = true;
            for (int j = i, k = 0; j < i+len; j++) {
                if (S.charAt(j) != Pn.charAt(k++)) {
                    isOk = false;
                    break;
                }
            }
            
            if (isOk) ans++;
        }

        System.out.println(ans);
    }
}
