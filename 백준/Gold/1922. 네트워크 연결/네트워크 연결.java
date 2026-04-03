import java.io.*;
import java.util.*;

public class Main {
    
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;
        
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    static int N;
    static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            edges[i] = new Edge(from, to, weight);
        }
        
        Arrays.sort(edges);
        
        makeSet();
        
        int pick = 0;
        int ans = 0;
        for (Edge e : edges) {
            if (unionSet(e.from, e.to)) {
                ans += e.weight;
                pick++;
                if (pick == N-1) break;
            }
        }
        
        System.out.println(ans);
    }
    
    public static void makeSet() {
        p = new int[N+1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
    }
    
    public static int find(int n) {
        if (n == p[n]) return n;
        return p[n] = find(p[n]);
    }
    
    public static boolean unionSet(int n1, int n2) {
        n1 = find(n1);
        n2 = find(n2);
        if (n1 == n2) return false;
        
        p[n1] = n2;
        return true;
    }
}