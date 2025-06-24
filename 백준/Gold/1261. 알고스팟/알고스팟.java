import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] maze;
    static int[][] dist;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        maze = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = input.charAt(j);
            }
        }

        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dijkstra(0, 0);

        System.out.println(dist[N-1][M-1]);
    }

    private static void dijkstra(int r, int c) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[r][c] = 0;
        pq.offer(new Node(r, c, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.cost > dist[curr.r][curr.c]) continue;

            for (int d = 0; d < 4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (maze[nr][nc] == '1') {
                    int nextCost = curr.cost + 1;
                    if (nextCost < dist[nr][nc]) {
                        dist[nr][nc] = nextCost;
                        pq.offer(new Node(nr, nc, dist[nr][nc]));
                    }
                } else {
                    int nextCost = curr.cost;
                    if (nextCost < dist[nr][nc]) {
                        dist[nr][nc] = nextCost;
                        pq.offer(new Node(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }

    }

    static class Node implements Comparable<Node> {
        int r, c, cost;

        Node (int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
