import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        q.add(new int[] {x, 0});
        visited[x] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == y) return curr[1];
            
            if (curr[0] * 3 <= y && !visited[curr[0] * 3]) {
                q.add(new int[] {curr[0] * 3, curr[1] + 1});
                visited[curr[0] * 3] = true;
            }
            
            if (curr[0] * 2 <= y && !visited[curr[0] * 2]) {
                q.add(new int[] {curr[0] * 2, curr[1] + 1});
                visited[curr[0] * 2] = true;
            }
            
            if (curr[0] + n <= y && !visited[curr[0] + n]) {
                q.add(new int[] {curr[0] + n, curr[1] + 1});
                visited[curr[0] + n] = true;
            }
        }
        
        return -1;
    }
}