import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
 
        List<int[]>[] adj = new ArrayList[D+1];
        for (int i = 0; i < D+1; i++) adj[i] = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); 
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());
            
            if (n2 <= D && n2 - n1 > n3) adj[n1].add(new int[] {n2, n3});  
        }
        
        int[] dist = new int[D+1];
        for (int i = 0; i <= D; i++) dist[i] = i;
        
        for (int i = 0; i < D; i++) {
            dist[i+1] = Math.min(dist[i+1], dist[i] + 1);
            for (int[] t : adj[i]) {
                int e = t[0];
                int d = t[1];
                
                dist[e] = Math.min(dist[e], dist[i] + d);
            }
        }
        
        System.out.println(dist[D]);
    }
}