import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(",");
            sb.append((Integer.parseInt(input[0])+Integer.parseInt(input[1])) + "\n");
        }

        System.out.println(sb);
    }
}
