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
            return this.weight - o.weight;
        }
    } 
    
    static int V;
    static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            edges[i] = new Edge(from, to, weight);
        }
        
        Arrays.sort(edges);
        
        makeSet();
        
        int pick = 0;
        int cost = 0;
        for (Edge edge : edges) {
            if (unionSet(edge.from, edge.to)) {
                cost += edge.weight;
                if (++pick == V - 1) break;
            }
        }
        
        System.out.println(cost);
    }
    
    static void makeSet() {
        p = new int[V+1];
        for (int i = 1; i <= V; i++) {
            p[i] = i;
        }
    }
    
    static int findSet(int v) {
        if (v == p[v]) return v;
        return p[v] = findSet(p[v]);
    }
    
    static boolean unionSet(int v1, int v2) {
        v1 = findSet(v1);
        v2 = findSet(v2);
        if (v1 == v2) return false;
        
        p[v1] = v2;
        return true;
    }
}