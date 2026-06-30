import java.util.*;

class Solution {
    
    class Edge implements Comparable<Edge> {
        int from;
        int to;
        int cost;
        
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
    
    int[] p;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Edge[] edges = new Edge[costs.length];
        for (int i = 0; i < costs.length; i++) {
            int[] c = costs[i];
            int from = c[0];
            int to = c[1];
            int cost = c[2];
            
            edges[i] = new Edge(from, to, cost);
        }
        
        Arrays.sort(edges);
        
        makeSet(n);
        
        int pick = 0;
        for (Edge edge : edges) {
            if (unionSet(edge.from, edge.to)) {
                answer += edge.cost;
                if (++pick == n - 1) break;
            }
        }
        
        return answer;
    }
    
    public void makeSet(int n) {
        p = new int[n];
        
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
    }
    
    public boolean unionSet(int v1, int v2) {
        v1 = findSet(v1);
        v2 = findSet(v2);
        
        if (v1 == v2) return false;
        
        p[v1] = v2;
        return true;
    }
    
    public int findSet(int v) {
        if (v == p[v]) return v;
        p[v] = findSet(p[v]);
        return p[v];
    }
}