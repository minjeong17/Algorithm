import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] cnt = new int[26];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            cnt[((int) input.charAt(i))-97]++;
        }

        for (int i = 0; i < cnt.length; i++) {
            sb.append(cnt[i] + " ");
        }

        System.out.println(sb);
    }
}
