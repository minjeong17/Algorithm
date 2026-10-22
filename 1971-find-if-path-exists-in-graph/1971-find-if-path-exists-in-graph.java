import java.util.*;

class Solution {
    int[] p;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;

        for (int[] edge : edges) {
            int rootA = find(edge[0]);
            int rootB = find(edge[1]);

            p[rootB] = rootA;
        }

        System.out.println(Arrays.toString(p));

        return find(source) == find(destination) ? true : false;
    }

    public int find(int v) {
        if (p[v] == v) return v;

        return p[v] = find(p[v]);
    }
}