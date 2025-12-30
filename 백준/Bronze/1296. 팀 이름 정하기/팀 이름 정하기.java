import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] engName = br.readLine().toCharArray();
        int[] cal = new int[4];
        for (char c : engName) {
            if (c == 'L') cal[0]++;
            else if (c == 'O') cal[1]++;
            else if (c == 'V') cal[2]++;
            else if (c == 'E') cal[3]++;
        }

        int nums = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        String answer = "";
        for (int i = 0; i < nums; i++) {
            String name = br.readLine();
            int[] tt = cal.clone();
            char[] tmp = name.toCharArray();
            for (char c : tmp) {
                if (c == 'L') tt[0]++;
                else if (c == 'O') tt[1]++;
                else if (c == 'V') tt[2]++;
                else if (c == 'E') tt[3]++;
            }

            int t = ((tt[0]+tt[1]) * (tt[0]+tt[2]) * (tt[0]+tt[3]) * (tt[1]+tt[2]) * (tt[1]+tt[3]) * (tt[2]+tt[3])) % 100;

            if (t > max) {
                max = t;
                answer = name;
            } else if (t == max) {
                if (name.compareTo(answer) < 0) {
                    answer = name;
                }
            }
        }

        System.out.println(answer);
    }
}
