import java.io.*;
import java.util.*;

public class Main {
    
    static List<int[]>[] adj;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            adj[a].add(new int[] {b, c});
            adj[b].add(new int[] {a, c});
        }
        
        System.out.println(calc(N));
    }
    
    public static int calc(int N) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        
        int[] cost = new int[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = 0;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            
            if (curr == N) return cost[N];
            
            for (int i = 0; i < adj[curr].size(); i++) {
                int[] next = adj[curr].get(i);
                
                if (cost[next[0]] > cost[curr] + next[1]) {
                    cost[next[0]] = cost[curr] + next[1];
                    pq.add(next[0]);
                }
            }
        }
        
        return cost[N];
    }
}