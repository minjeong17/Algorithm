import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        if (x == y) return 0;
        else return bfs(x, y, n);
    }
    
    public int bfs(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[y+1];
        
        q.add(x);
        visited[x] = true;
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                
                if (curr == y) return cnt;
                
                if (curr+n <= y && !visited[curr+n]) {
                    visited[curr+n] = true;
                    q.add(curr+n);
                }
                
                if (curr*2 <= y && !visited[curr*2]) {
                    visited[curr*2] = true;
                    q.add(curr*2);
                }
                
                if (curr*3 <= y && !visited[curr*3]) {
                    visited[curr*3] = true;
                    q.add(curr*3);
                }
            }

            cnt++;
        }
        
        return -1;
    }
}