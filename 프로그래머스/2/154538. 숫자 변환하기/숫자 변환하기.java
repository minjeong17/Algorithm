import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        q.add(x);
        visited[x] = true;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                
                if (curr == y) return answer;
                
                if (curr + n <= y && !visited[curr + n]) {
                    q.add(curr + n);
                    visited[curr + n] = true;
                }
                
                if (curr * 2 <= y && !visited[curr * 2]) {
                    q.add(curr * 2);
                    visited[curr * 2] = true;
                }
                
                if (curr * 3 <= y && !visited[curr * 3]) {
                    q.add(curr * 3);
                    visited[curr * 3] = true;
                }
            }
            
            answer++;
        }
        
        return -1;
    }
}