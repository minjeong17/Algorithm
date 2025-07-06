import java.util.*;

class Solution {
    
    int answer, len;
    List<Integer>[] adj;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        answer = 0;
        len = computers.length;
        
        adj = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && computers[i][j] == 1) adj[i].add(j);
            }
        }
        
        visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs (int n) {
        visited[n] = true;
        
        for (int v : adj[n]) {
            if (!visited[v]) dfs(v);
        }
    }
}