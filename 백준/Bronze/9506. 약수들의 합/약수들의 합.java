import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder answer = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(1);
            int sum = 1;
            for (int i = 2; i * i <= n; i++) {
                if (i * i == n) {
                    pq.add(i);
                    sum += i;
                }
                else if (n % i == 0) {
                    pq.add(i);
                    pq.add(n / i);
                    sum += i;
                    sum += n / i;
                }
            }

            if (sum == n) {
                answer.append(n).append(" = ");
                while (!pq.isEmpty()) {
                    answer.append(pq.poll());
                    if (!pq.isEmpty()) answer.append(" + ");
                }
            } else {
                answer.append(n).append(" is NOT perfect.");
            }
            answer.append("\n");
        }

        System.out.println(answer.toString());
    }
}
