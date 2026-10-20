import java.util.*;

class Solution {
    int N;
    int[] dist;
    List<int[]>[] adj;
    public int solution(int N, int[][] road, int K) {
        this.N = N;
        int answer = 0;

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        
        for (int[] r : road) {
            adj[r[0]].add(new int[] {r[1], r[2]});
            adj[r[1]].add(new int[] {r[0], r[2]});
        }
        
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        dijkstra(1);
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
    
    public void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] {start, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            for (int[] t : adj[curr[0]]) {
                if (dist[t[0]] > dist[curr[0]] + t[1]) {
                    dist[t[0]] = dist[curr[0]] + t[1];
                    pq.add(new int[] {t[0], dist[t[0]]});
                }
            }
        }
    }
} 