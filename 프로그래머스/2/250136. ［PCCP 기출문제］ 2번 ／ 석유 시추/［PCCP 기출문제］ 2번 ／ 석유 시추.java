import java.util.*;

class Solution {
    
    int totalR, totalC;
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    boolean[][] visited;
    int[][] cntOil;
    
    public int solution(int[][] land) {
        
        totalR = land.length;
        totalC = land[0].length;
        visited = new boolean[totalR][totalC];
        cntOil = new int[totalR][totalC];
        
        Map<Integer, Integer> landCnt = new HashMap<>();
        int h = 1;
        for (int i = 0; i < totalR; i++) {
            for (int j = 0; j < totalC; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int cnt = bfs(i, j, land, h);
                    landCnt.put(h, cnt);
                    h++;
                }
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for (int j = 0; j < totalC; j++) {
            int tmp = 0;
            Set<Integer> hs = new HashSet<>();
            for (int i = 0; i < totalR; i++) {
                if (cntOil[i][j] != 0) {
                    hs.add(cntOil[i][j]);
                }
            }
            for (int n : hs) {
                tmp += landCnt.get(n);
            }
            
            answer = Math.max(answer, tmp);
        }       
        
        
        return answer;
    }
    
    public int bfs (int r, int c, int[][] land, int h) {
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[] {r, c});
        visited[r][c] = true;
        cntOil[r][c] = h;
        
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                
                if (nr < 0 || nr >= totalR || nc < 0 || nc >= totalC) continue;
                if (land[nr][nc] == 0 || visited[nr][nc]) continue;
                
                visited[nr][nc] = true;
                q.add(new int[] {nr, nc});
                cntOil[nr][nc] = h;
                cnt++;
            }
        }
        
        return cnt;
    }
}