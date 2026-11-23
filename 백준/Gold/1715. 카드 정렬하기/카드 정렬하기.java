import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        
        int answer = 0;
        while (pq.size() > 1) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            
            answer += n1 + n2;
            pq.add(n1 + n2);
        }
        
        System.out.println(answer);
    }
}