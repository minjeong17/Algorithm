import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String input = br.readLine();

            String[] words = input.split(" ");

            StringBuilder rev = new StringBuilder();
            for (String word : words) {
                for (int i = word.length()-1; i >= 0; i--) {
                    rev.append(word.charAt(i));
                }
                rev.append(" ");
            }
            sb.append(rev).append("\n");
        }

        System.out.println(sb);
    }
}
