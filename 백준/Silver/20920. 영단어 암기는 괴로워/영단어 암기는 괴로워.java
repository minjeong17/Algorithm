import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                cnt.put(word, cnt.getOrDefault(word, 0) + 1);
            }
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            if (cnt.get(o1) == cnt.get(o2)) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return cnt.get(o2) - cnt.get(o1);
        });
                
        for (String w : cnt.keySet()) {
            pq.add(w);
        }
        
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()) {
            ans.append(pq.poll()).append("\n");
        }
        
        System.out.println(ans.toString());
    }
}