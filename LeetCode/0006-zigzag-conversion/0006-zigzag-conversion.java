import java.util.*;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        int len = s.length();
        char[][] zigzag = new char[numRows][len];

        int[] dr = {1, -1};
        int[] dc = {0, 1};

        int r = 0;
        int c = 0;
        int d = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            zigzag[r][c] = ch;

            r += dr[d];
            c += dc[d];

            if (r  == 0 || r == numRows - 1) d = (d + 1) % 2;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len; j++) {
                if (zigzag[i][j] != '\0') ans.append(zigzag[i][j]);
            }
        }

        return ans.toString();
    }
}