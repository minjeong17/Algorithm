import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[] {priorities[i], i});
        }
        
        Arrays.sort(priorities);
        
        int answer = 0;
        int idx = priorities.length - 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            if (curr[0] == priorities[idx]) {
                if (curr[1] == location) return answer + 1;
                else {
                    answer++;
                    idx--;
                }
            } else {
                q.add(curr);
            }
        }
        
        return answer;
    }
}