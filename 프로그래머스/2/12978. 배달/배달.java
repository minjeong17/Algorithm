import java.util.*;

class Solution {
    int N;
    List<int[]>[] adj;
    int[] dist;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        this.N = N;

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] r : road) {
            adj[r[0]].add(new int[] {r[1], r[2]});
            adj[r[1]].add(new int[] {r[0], r[2]});
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        dijkstra(1);
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
    
    public void dijkstra(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int[] next : adj[curr]) {
                int to = next[0];
                int weight = next[1];
                if (dist[curr] + weight < dist[to]) {
                    dist[to] = Math.min(dist[curr] + weight, dist[to]);
                    q.add(to);
                }
            }
        }
    }
}