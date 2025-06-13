import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        int len = input.length();
        int startIdx = 0;
        while (true) {
            if (startIdx + 10 < len) {
                sb.append(input.substring(startIdx, startIdx+10) + "\n");
            } else {
                sb.append(input.substring(startIdx));
                break;
            }
            startIdx += 10;
        }

        System.out.println(sb);
    }
}
