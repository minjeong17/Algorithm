import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] names = new int[26];
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            names[name.charAt(0)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (names[i] >= 5) sb.append((char)(i+97));
        }

        if (sb.length() == 0) System.out.println("PREDAJA");
        else System.out.println(sb.toString());
    }
}
