import java.util.*;

class Solution {
    List<Integer>[] adjList;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    adjList[i].add(j);
                }
            }
        }
        
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int w : adjList[curr]) {
                if (visited[w]) continue;
                visited[w] = true;
                q.add(w);
            }
        }
    }
}