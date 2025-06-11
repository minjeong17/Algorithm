import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, maxNum, maxAns;
    static int[][] nums;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N][M];

        maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
                maxNum = Integer.max(maxNum, nums[i][j]);
            }
        }

        maxAns = Integer.MIN_VALUE;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 1, nums[i][j]);
                checkLast(i, j);
            }
        }

        System.out.println(maxAns);
    }

    private static void checkLast(int r, int c) {

        // 상
        if (r-1 >= 0 && c-1 >= 0 && c + 1 < M) {
            maxAns = Integer.max(maxAns, nums[r][c]+nums[r-1][c-1]+nums[r-1][c]+nums[r-1][c+1]);
        }
        // 하
        if (r+1 < N && c-1 >= 0 && c + 1 < M) {
            maxAns = Integer.max(maxAns, nums[r][c]+nums[r+1][c-1]+nums[r+1][c]+nums[r+1][c+1]);
        }
        // 좌
        if (r-1 >= 0 && r+1 < N && c-1 >= 0) {
            maxAns = Integer.max(maxAns, nums[r][c]+nums[r-1][c-1]+nums[r][c-1]+nums[r+1][c-1]);
        }
        // 우
        if (r-1 >= 0 && r+1 < N && c+1 < M) {
            maxAns = Integer.max(maxAns, nums[r][c]+nums[r-1][c+1]+nums[r][c+1]+nums[r+1][c+1]);
        }
    }

    private static void dfs(int r, int c, int cnt, int sum) {
        if (cnt >= 4) {
            maxAns = Integer.max(maxAns, sum);
            return;
        }

        if (sum + (4-cnt)*maxNum < maxAns) return;

        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (visited[nr][nc]) continue;

            dfs(nr, nc, cnt+1, sum+nums[nr][nc]);
        }

        visited[r][c] = false;
    }
}
