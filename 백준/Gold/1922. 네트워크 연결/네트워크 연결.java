import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            edges.add(new int[] {a, b, c});
        }
        
        Collections.sort(edges, (o1, o2) -> o1[2] - o2[2]);
        
        makeSet();
        
        int pick = 0;
        int answer = 0;
        for (int[] e : edges) {
            if (unionSet(e[0], e[1])) {
                answer += e[2];
                pick++;
                if (pick == N-1) break;
            } 
        }
        
        System.out.println(answer);
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