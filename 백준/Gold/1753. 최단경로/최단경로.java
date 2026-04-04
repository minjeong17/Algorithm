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
    
    static int V;
    static List<Edge>[] adj;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        int K = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            adj[from].add(new Edge(to, weight));
        }
        
        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dijkstra(K);
        
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                ans.append("INF\n");
            } else {
                ans.append(dist[i]).append("\n");
            }
        }
        
        System.out.println(ans.toString());
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];
        
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            
            if (visited[curr.to]) continue;
            visited[curr.to] = true;
            
            for (Edge e : adj[curr.to]) {
                if (!visited[e.to] && dist[e.to] > e.weight + dist[curr.to]) {
                    dist[e.to] = e.weight + dist[curr.to];
                    pq.add(new Edge(e.to, dist[e.to]));
                }
            }
        }
    }
}