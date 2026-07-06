import java.util.*;

class Solution {
    int n, destination;
    List<Integer>[] adjList;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        this.n = n;
        this.destination = destination;
        
        int[] answer = new int[sources.length];
        
        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            adjList[road[0]].add(road[1]);
            adjList[road[1]].add(road[0]);
        }
                
        for (int i = 0; i < sources.length; i++) {
            if (sources[i] == destination) answer[i] = 0;
            else answer[i] = bfs(sources[i]);
        }
        
        
        return answer;
    }
    
    public int bfs (int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        q.add(start);
        visited[start] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                
                if (curr == destination) return cnt;
                
                for (int v : adjList[curr]) {
                    if (visited[v]) continue;
                    
                    visited[v] = true;
                    q.add(v);
                }
            }
            
            cnt++;
        }
        
        return -1;
    }
}