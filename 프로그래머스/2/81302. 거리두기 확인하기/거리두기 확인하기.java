import java.util.*;

class Solution {
    boolean[][]  visited;
    Queue<int[]> q;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    String[] pplaces;
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[5];
        for(int i=0; i<5; i++) {
            pplaces = places[i];
            boolean flag = true;
            outer:for(int r=0;r<5;r++){
                for(int c=0;c<5;c++){
                    if(pplaces[r].charAt(c)=='P') {
                        visited = new boolean[5][5];
                        q = new LinkedList<>();
                        if (bfs(r, c) == 0) {
                            flag = false;
                            break outer;
                        }
                    }
                }
            }
            if (flag) answer[i] = 1;
            else answer[i] = 0;
            // answer[i] = bfs();
        }
        
        return answer;
    }
    
    public int bfs(int r, int c) {
        q.add(new int[] {r, c});
        int dist = 0;
        
        while(!q.isEmpty()){
            
            if (dist == 2) return 1;
            
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                visited[curr[0]][curr[1]] = true;
                
                for(int d=0; d<4; d++){
                    int nr = curr[0] + dr[d];
                    int nc = curr[1] + dc[d];
                    if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
                    
                    if(visited[nr][nc]) continue;
                    if(pplaces[nr].charAt(nc)=='X') continue;
                    if(pplaces[nr].charAt(nc)=='P') return 0;
                    
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
            dist++;
        }
        return 1;
    }
}