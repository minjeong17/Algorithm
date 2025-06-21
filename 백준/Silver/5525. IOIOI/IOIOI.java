import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine()); 
        String S = br.readLine();

        int ans = 0;
        int cnt = 0;
        for (int i = 1; i < M-1;) {
            if (S.charAt(i) == 'O' && S.charAt(i+1) == 'I' && S.charAt(i-1) == 'I') {
                cnt++;
                i += 2;
                if (cnt >= N) ans++;
            } else {
                cnt = 0;
                i++;
            }
        }

        System.out.println(ans);
    }
}
