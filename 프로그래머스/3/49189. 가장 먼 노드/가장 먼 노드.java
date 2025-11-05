import java.util.*;

class Solution {
    
    List<Integer>[] adj;
    int[] lenArr;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        lenArr = new int[n+1];
        Arrays.fill(lenArr, Integer.MAX_VALUE);
        lenArr[1] = 0;
        find(n);
        
        int maxLen = Integer.MIN_VALUE;
        for (int i = 2; i <= n; i++) {
            if (lenArr[i] == maxLen) {
                answer++;
            } else if (lenArr[i] > maxLen) {
                maxLen = lenArr[i];
                answer = 1;
            }
        }
        return answer;
    }
    
    public void find(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                
                for (int j : adj[curr]) {
                    if (lenArr[curr]+1 < lenArr[j]) {
                        lenArr[j] = lenArr[curr]+1;
                        q.add(j);
                    }
                }
            }
        }
    }
}