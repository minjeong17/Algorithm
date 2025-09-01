import java.util.*;

class Solution {
    
    List<Integer>[] adj;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];
            
            adj[from].add(to);
            adj[to].add(from);
        }
        
        for (int[] wire : wires) {
            visited = new boolean[n+1];
            int tmp = count(1, wire[0], wire[1]);
            answer = Math.min(answer, Math.abs(n-tmp-tmp));
            if (answer == 0) break;
        }
        
        return answer;
    }
    
    public int count(int num, int v1, int v2) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(num);
        visited[num] = true;
        
        int tmp = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int i : adj[curr]) {
                
                if (visited[i]) continue;
                if ((curr == v1 && i == v2) || (curr == v2 && i == v1)) continue;
                
                visited[i] = true;
                q.add(i);
                tmp++;
            }
        }
        
        return tmp;
    }
}