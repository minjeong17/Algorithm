import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        
        int lenX = park.length;
        int lenY = park[0].length;
        int[][] sumArr = new int[lenX+1][lenY+1];
        for (int i = 1; i <= lenX; i++) {
            for (int j = 1; j <= lenY; j++) {
                sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1];
                if ("-1".equals(park[i-1][j-1])) sumArr[i][j] += 1;
            }
        }
        
        Arrays.sort(mats);
        for (int m = mats.length-1; m >= 0; m--) {
            int matLen = mats[m];
            for (int i = matLen; i <= lenX; i++) {
                for (int j = matLen; j <= lenY; j++) {
                    int tmp = sumArr[i][j] - (sumArr[i-matLen][j] + sumArr[i][j-matLen] - sumArr[i-matLen][j-matLen]);
                    if (tmp == matLen*matLen) return matLen;
                }
            }
        }
        
        return -1;
    }
}