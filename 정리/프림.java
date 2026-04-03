package 정리;

import java.io.*;
import java.util.*;

public class 프림 {
    // 그래프에서 모든 정점을 최소 비용으로 연결하는 "최소 신장 트리(MST)"를 구하는 알고리즘
    // 정점 중심 알고리즘
    // 조건 : 가중치가 있는 그래프, 무방향, 모든 정점 연결 가능
    // 아무 정점 하나에서 시작해서 현재 트리에 포함된 정점과 포함되지 않은 정점을 잇는 간선 중 가중치가 가장 작은 간선을 선택하여 트리를 확장한다

    static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 -> 0번
        int E = Integer.parseInt(st.nextToken()); // 간선

        List<Edge>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        } // 인접리스트 생성

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 무향 그래프
            adj[from].add(new Edge(to, weight));
            adj[to].add(new Edge(from, weight));
        } // 간선 입력

        int ans = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V]; // 트리에 소속인지 아닌지 기록

        // 0번 고름 -> 0번과 연결되어있는 간선 모두 넣자
        int pick = 0;
        pq.add(new Edge(0, 0));

        while (pick < V) {
            Edge e = pq.poll();
            if (visited[e.to]) continue;

            ans += e.weight;
            visited[e.to] = true;
            pick++;

            pq.addAll(adj[e.to]);
        }

        System.out.println(ans);

    }

    static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
            + "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
