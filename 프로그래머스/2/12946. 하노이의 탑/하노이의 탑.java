import java.util.*;

class Solution {
    public List<int[]> way;
    public int[][] solution(int n) {
        
        way = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        
        int[][] answer = new int[way.size()][2];
        for (int i = 0; i < way.size(); i++) {
            answer[i][0] = way.get(i)[0];
            answer[i][1] = way.get(i)[1];
        }
        
        return answer;
    }
    
    public void hanoi(int n, int start, int end, int sub) {
        if (n == 1) {
            way.add(new int[] {start, end});
            return;
        }
        
        hanoi(n-1, start, sub, end);
        way.add(new int[] {start, end});
        hanoi(n-1, sub, end, start);
    }
}