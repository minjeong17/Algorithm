import java.util.*;

class Solution {
    int[] dr = {0, 1, 0, -1};  // 우 하 좌 상
    int[] dc = {1, 0, -1, 0};
    
    int[][] nums;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        nums = new int[rows][columns];
        int n = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                nums[i][j] = n++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }
        
        return answer;
    }
    
    public int rotate(int[] queries) {
        int startR = queries[0] - 1;
        int startC = queries[1] - 1;
        int endR = queries[2] - 1;
        int endC = queries[3] - 1;
        
        int minN = nums[startR][startC];
        int prev = nums[startR][startC];
        int d = 0;
        int r = startR;
        int c = startC;
        while (true) {
            int nr = r + dr[d];
            int nc = c + dc[d];
                        
            if (nr == startR && nc == startC) {
                nums[nr][nc] = prev;
                minN = Math.min(minN, nums[nr][nc]);
                break;
            }
            
            int tmp = nums[nr][nc];
            nums[nr][nc] = prev;
            prev = tmp;
            
            minN = Math.min(minN, nums[nr][nc]);
            
            r = nr;
            c = nc;
            
            if (r + dr[d] == startR - 1 || r + dr[d] == endR + 1 || c + dc[d] == startC - 1 || c + dc[d] == endC + 1) d++;
        }
        
        return minN;
    }
}