import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            boolean isBomb = true;
            if (sb.length() >= bombLen) {
                int idx = bombLen - 1;
                for (int j = sb.length()-1; j >= sb.length()-bombLen; j--) {
                    if (sb.charAt(j) != bomb.charAt(idx--)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    sb.delete(sb.length()-bombLen, sb.length());
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}
