import java.util.*;

class Solution {
    public String[][] park;
    public int solution(int[] mats, String[][] park) {
        this.park = park;
        
        int answer = -1;
        
        Arrays.sort(mats);
        
        int parkR = park.length;
        int parkC = park[0].length;
        outer:
        for (int i = mats.length - 1; i >= 0; i--) {
            int len = mats[i];
            for (int r = 0; r <= parkR - len; r++) {
                for (int c = 0; c <= parkC - len; c++) {
                    if (park[r][c].equals("-1") && park[r+len-1][c+len-1].equals("-1")) {
                        if (check(r, c, len)) {
                            answer = len;
                            break outer;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    public boolean check(int r, int c, int len) {
        for (int i = r; i < r + len; i++) {            
            for (int j = c; j < c + len; j++) {
                if (!park[i][j].equals("-1")) return false;
            } 
        }
        
        return true;
    }
}