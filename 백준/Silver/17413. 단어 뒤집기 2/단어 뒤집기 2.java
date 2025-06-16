import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean insideTag = false;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '<') {
                ans.append(word.reverse());
                word.setLength(0);
                insideTag = true;
                ans.append(ch);
            } else if (ch == '>') {
                insideTag = false;
                ans.append(ch);
            } else if (insideTag) {
                ans.append(ch);
            } else {
                if (ch == ' ') {
                    ans.append(word.reverse());
                    ans.append(' ');
                    word.setLength(0);
                } else {
                    word.append(ch);
                }
            }
        }

        ans.append(word.reverse());

        System.out.println(ans);

    }
}
