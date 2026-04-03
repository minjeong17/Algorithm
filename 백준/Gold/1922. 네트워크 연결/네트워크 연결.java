import java.io.*;
import java.util.*;

public class Main {
    
    static class Edge implements Comparable<Edge> {
        int to;
        int weight;
        
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        List<Edge>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            adj[from].add(new Edge(to, weight));
            if (from != to) adj[to].add(new Edge(from, weight));
        }
                
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        pq.add(new Edge(1, 0));
        int pick = 0;
        int ans = 0;
        
        while (pick < N && !pq.isEmpty()) {
            Edge e = pq.poll();
            if (visited[e.to]) continue;
            
            ans += e.weight;
            visited[e.to] = true;
            pick++;
            
            for (Edge ed : adj[e.to]) {
                if (!visited[ed.to]) {
                    pq.add(ed);
                }
            }
        }
        
        System.out.println(ans);
    }
}