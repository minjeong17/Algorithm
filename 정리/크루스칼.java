import java.io.*;
import java.util.*;

public class 크루스칼 {
    // 그래프에서 모든 정점을 최소 비용으로 연결하는 "최소 신장 트리(MST)"를 구하는 알고리즘
    // 간선 중심 알고리즘 -> 모든 간선을 비용 순으로 정렬한 뒤 작은 것부터 선택
    // 조건 : 가중치가 있는 그래프, 무방향, 모든 정점 연결 가능

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {  // weight 기준 오름차순 정렬
            return this.weight - o.weight;
        }
    }

    static int V;
    private static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 개수 (시작번호 확인 -> 0번부터 시작)
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edges); // 간선의 비용 기준으로 정렬

        // UNION-FIND를 이용해서 두 정점의 연결 여부 판단
        // 1. 그룹을 생성
        makeSet();

        // 선택된 정점의 수 올리기
        int pick = 0; int cost = 0;
        for (Edge edge : edges) {
            if (unionSet(edge.from, edge.to)) {
                cost += edge.weight;
                if (++pick == V - 1) break;
            }
        }

        System.out.println(cost);
    }

    private static void makeSet() {
        // 대상 원소들을 모두 각각 독립된 집합으로 분리하는 과정

        p = new int[V];
        for (int i = 0; i < V; i++) {
            p[i] = i;
        }
    }

    private static int findSet(int v) { // 특정 정점의 대표를 넘기자
        // 대상 원소가 어떤 대상을 가리키는지, 즉 어떤 집합에 포함되어 있는지 (부모가 누구인지) 파악하는 과정

        if (v == p[v]) return v;
        return p[v] = findSet(p[v]);
    }

    private static boolean unionSet(int v1, int v2) {
        // 서로소 집합을 하나의 집합으로 합치는 과정

        v1 = findSet(v1);
        v2 = findSet(v2);
        if (v1 == v2) return false;

        p[v1] = v2;
        return true;
    }


    static String input =
            "7 11\r\n"
            + "0 1 32\r\n"
            + "0 2 31\r\n"
            + "0 5 60\r\n"
            + "0 6 51\r\n"
            + "1 2 21\r\n"
            + "2 4 46\r\n"
            + "2 6 25\r\n"
            + "3 4 34\r\n"
            + "3 5 18\r\n"
            + "4 5 40\r\n"
            + "4 6 51\r\n"
            + "";
}
