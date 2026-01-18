import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String first = br.readLine();
        int[] base = new int[26];
        for (char c : first.toCharArray()) base[c - 'A']++;

        int ans = 0;
        int len = first.length();

        for (int i = 0; i < N - 1; i++) {
            String w = br.readLine();
            int[] tmp = base.clone();

            int same = 0;
            for (char c : w.toCharArray()) {
                int idx = c - 'A';
                if (tmp[idx] > 0) {
                    tmp[idx]--;
                    same++;
                }
            }

            if (w.length() == len) {
                if (same == len || same == len - 1) ans++;
            } else if (w.length() == len + 1) {
                if (same == len) ans++;
            } else if (w.length() == len - 1) {
                if (same == len - 1) ans++;
            }
        }

        System.out.println(ans);
    }
}
