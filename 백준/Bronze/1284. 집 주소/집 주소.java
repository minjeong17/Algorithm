import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        StringBuilder ans = new StringBuilder();
        while (!(input = br.readLine()).equals("0")) {
            int len = 1;
            for (int i = 0; i < input.length(); i++) {
                char curr = input.charAt(i);

                if (curr == '0') len += 4;
                else if (curr == '1') len += 2;
                else len += 3;

                len++;
            }
            ans.append(len).append("\n");
        }
        
        System.out.println(ans.toString());
    }
}
