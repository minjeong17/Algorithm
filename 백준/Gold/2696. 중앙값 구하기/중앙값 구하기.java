import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine());
            answer.append((M/2)+1).append("\n");

            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int m = 0; m < M; m++) {
                if (m != 0 && m % 10 == 0) st = new StringTokenizer(br.readLine());
                list.add(Integer.parseInt(st.nextToken()));
                if (m % 2 == 0) {
                    Collections.sort(list);
                    answer.append(list.get(m/2)).append(" ");
                }
                if (m != 0 && m % 19 == 0) {
                    answer.deleteCharAt(answer.length() - 1);
                    answer.append("\n");
                }
            }
            if (t < T-1) answer.append("\n");
        }

        System.out.println(answer.toString());
    }
}
