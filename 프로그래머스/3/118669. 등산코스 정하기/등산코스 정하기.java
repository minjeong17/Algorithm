import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        List<int[]>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] path : paths) {
            int from = path[0];
            int to = path[1];
            int cost = path[2];
            
            adj[from].add(new int[] {to, cost});
            adj[to].add(new int[] {from, cost});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Set<Integer> summitSet = new HashSet<>();
        for (int summit : summits) summitSet.add(summit);
        
        Set<Integer> gateSet = new HashSet<>();
        for (int gate : gates) {
            gateSet.add(gate);
            pq.add(new int[] {gate, 0});
            dist[gate] = 0;
        }
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int c = curr[0];
            int i = curr[1];
            
            if (summitSet.contains(c)) continue;
            if (dist[c] < i) continue;
            
            for (int[] p : adj[c]) {
                int to = p[0];
                int intens = p[1];
                
                if (gateSet.contains(to)) continue;
                
                int nn = Math.max(intens, i);
                if (nn < dist[to]) {
                    dist[to] = nn;
                    pq.add(new int[] {to, nn});
                }
            }
        }
        
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        
        Arrays.sort(summits);
        for (int summit : summits) {
            if (dist[summit] < answer[1]) {
                answer[0] = summit;
                answer[1] = dist[summit];
            }
        }
        
        return answer;
    }
}