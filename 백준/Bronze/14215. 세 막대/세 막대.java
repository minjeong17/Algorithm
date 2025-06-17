import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] len = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            len[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(len);

        while (true) {
            if (len[2] < len[0] + len[1]) {
                break;
            } else {
                len[2]--;
                Arrays.sort(len);
            }
        }

        System.out.println(len[0] + len[1] + len[2]);
    }
}
