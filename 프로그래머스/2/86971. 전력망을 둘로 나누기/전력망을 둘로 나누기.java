import java.util.*;

class Solution {
    int n;
    List<Integer>[] adj;
    public int solution(int n, int[][] wires) {
        this.n = n;
        int answer = Integer.MAX_VALUE;
        
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        
        for (int[] wire : wires) {
            adj[wire[0]].add(wire[1]);
            adj[wire[1]].add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int n1 = bfs(wire[0], wire[1]);
            int n2 = bfs(wire[1], wire[0]);
            
            answer = Math.min(answer, Math.abs(n1 - n2));
        }
        
        return answer;
    }
    
    public int bfs(int startW, int blockW) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        
        q.add(startW);
        visited[startW] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            cnt++;
            
            for (int n : adj[curr]) {
                if (visited[n] || n == blockW) continue;
                
                visited[n] = true;
                q.add(n);
            }
        }
        
        return cnt;
    }
}