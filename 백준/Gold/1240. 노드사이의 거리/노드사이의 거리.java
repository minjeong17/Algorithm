import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static List<int[]>[] adj;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            adj[n1].add(new int[] {n2, d});
            adj[n2].add(new int[] {n1, d});
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            ans.append(find(n1, n2)).append("\n");
        }
        
        System.out.println(ans.toString());
    }
    
    public static int find(int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        
        q.add(new int[] {start, 0});
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == end) return curr[1];
            
            for (int[] next : adj[curr[0]]) {
                if (!visited[next[0]]) {
                    visited[next[0]] = true;
                    q.add(new int[] {next[0], curr[1] + next[1]});
                }
            }
        }
        
        return -1;
    } 
}