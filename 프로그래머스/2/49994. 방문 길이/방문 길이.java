import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Map<Character, Integer> dir = new HashMap<>();
        dir.put('U', 0); dir.put('D', 1);
        dir.put('L', 2); dir.put('R', 3);
        
        int r = 0, c = 0;
        
        boolean[][][] visited = new boolean[11][11][4];
        
        for (int i = 0; i < dirs.length(); i++) {
            int d = dir.get(dirs.charAt(i));
            
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if (nr < -5 || nr > 5 || nc < -5 || nc > 5) continue;
            if (!visited[nr+5][nc+5][d]) {
                answer++;
                visited[nr+5][nc+5][d] = true;
                if (d == 0) visited[r+5][c+5][1] = true;
                else if (d == 1) visited[r+5][c+5][0] = true;
                else if (d == 2) visited[r+5][c+5][3] = true;
                else visited[r+5][c+5][2] = true;
            }
            
            r = nr;
            c = nc;
        }
        
        return answer;
    }
}