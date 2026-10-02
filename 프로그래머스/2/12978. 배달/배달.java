import java.util.*;

class Solution {
    int N;
    List<int[]>[] adjList;
    int[] dist;
    public int solution(int N, int[][] road, int K) {
        this.N = N;
        int answer = 0;

        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();
        for (int[] r : road) {
            adjList[r[0]].add(new int[] {r[1], r[2]});
            adjList[r[1]].add(new int[] {r[0], r[2]});
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
    
    public void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[N+1];
        pq.add(new int[] {start, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            if (visited[curr[0]]) continue;
            visited[curr[0]] = true;
            
            for (int[] node : adjList[curr[0]]) {
                int next = node[0];
                int d = node[1];
                
                if (!visited[next] && dist[next] > dist[curr[0]] + d) {
                    dist[next] = dist[curr[0]] + d;
                    pq.add(new int[] {next, dist[next]});
                }
            }
        }
    }
}