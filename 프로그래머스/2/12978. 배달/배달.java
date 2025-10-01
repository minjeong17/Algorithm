import java.util.*;

class Solution {
    
    int[] len;
    List<int[]>[] adj;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            int s = r[0];
            int e = r[1];
            int w = r[2];
            
            adj[s].add(new int[] {e, w});
            adj[e].add(new int[] {s, w});
        }
        
        len = new int[N+1];
        Arrays.fill(len, Integer.MAX_VALUE);
        len[1] = 0;
        find();
        
        for (int i = 1; i <= N; i++) {
            if (len[i] <= K) answer++;
        }
        
        return answer;
    }
    
    public void find() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (int[] arr : adj[curr]) {
                int end = arr[0];
                int weight = arr[1];
                
                if (len[curr] + weight < len[end]) {
                    len[end] = len[curr] + weight;
                    q.add(end);
                }
            }
        }
    }
}