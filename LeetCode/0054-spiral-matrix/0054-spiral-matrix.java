import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int m = matrix.length;
        int n = matrix[0].length;

        int d = 0;
        int r = 0;
        int c = 0;
        while (answer.size() < m * n) {
            answer.add(matrix[r][c]);
            matrix[r][c] = 1000;

            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n || matrix[nr][nc] == 1000) {
                d = (d + 1) % 4;

                nr = r + dr[d];
                nc = c + dc[d];
            }

            r = nr;
            c = nc;
        }


        return answer;
    }
}