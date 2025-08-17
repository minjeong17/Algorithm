import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e');
        vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E');
        vowels.add('I'); vowels.add('O'); vowels.add('U');

        String input;
        StringBuilder sb = new StringBuilder();
        while (!(input = br.readLine()).equals("#")) {
            int answer = 0;
            for (int i = 0; i < input.length(); i++) {
                if (vowels.contains(input.charAt(i))) answer++;
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
