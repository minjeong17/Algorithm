import java.io.BufferedReader;
import java.io.StringReader;
import java.util.*;

public class 다익스트라 {
    // 특정 정점에서 다른 모든 정점으로 가는 최단 거리
    // 음의 간선은 포함할 수 없음

    static class Edge implements Comparable<Edge> {
        int to, cost;

        public Edge(int v, int w) {
            this.to = v;
            this.cost = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int V, E;
    static List<Edge>[] adjList;
    static int[] dist;

    static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        } // 초기화

        dist = new int[V];
        Arrays.fill(dist, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            adjList[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        dijkstra(0);

        System.out.println(Arrays.toString(dist));
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V];

        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (visited[curr.to]) continue;
            visited[curr.to] = true;

            for (Edge node : adjList[curr.to]) {
                if (!visited[node.to] && dist[node.to] > dist[curr.to] + node.cost) {
                    dist[node.to] = dist[curr.to] + node.cost;
                    pq.add(new Edge(node.to, dist[node.to]));
                }
            }
        }
    }
}
