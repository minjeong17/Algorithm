import java.util.*;

class Solution {
    
    // 상하좌우
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        Map<Character, Integer> direction = new HashMap<>();
        direction.put('N', 0); direction.put('S', 1);
        direction.put('W', 2); direction.put('E', 3);
        
        int lenX = park.length;
        int lenY = park[0].length();
        
        int r = -1; int c = -1;
        char[][] map = new char[lenX][lenY];
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                map[i][j] = park[i].charAt(j);
                if (map[i][j] == 'S') {
                    r = i;
                    c = j;
                }
            }
        }
        
        for (String dir : routes) {
            
            char op = dir.charAt(0);
            int n = Integer.parseInt(dir.charAt(2)+"");
            
            int tmpR = r; int tmpC = c;
            boolean isOk = true;
            for (int i = 0; i < n ; i++) {
                tmpR += dr[direction.get(op)];
                tmpC += dc[direction.get(op)];
                
                if (tmpR < 0 || tmpR >= lenX || tmpC < 0 || tmpC >= lenY || map[tmpR][tmpC] == 'X') {
                    isOk = false;
                    break;
                }
            }
            
            if (isOk) {
                r = tmpR;
                c = tmpC;
            }
        }
        
        return new int[] {r, c};
    }
}