import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 시림
        int M = Integer.parseInt(st.nextToken());  // 파티

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        Set<Integer> knows = new HashSet<>();
        for (int i = 0; i < t; i++) {
            knows.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer>[] adj = new HashSet[M];
        for (int i = 0; i < M; i++) {
            adj[i] = new HashSet<>();
        }

        boolean[] isOk = new boolean[M];
        Arrays.fill(isOk, true);

        for (int i = 0; i < M; i++) {  // 각 파티에 누가 참여하는지
            st = new StringTokenizer(br.readLine());
            int pNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < pNum; j++) {
                int p = Integer.parseInt(st.nextToken());
                adj[i].add(p);
            }
        }

        if (knows.size() == 0) System.out.println(M);
        else {
            for (int ii = 0; ii < M; ii++) {
                for (int i = 0; i < M; i++) {
                    for (int a : adj[i]) {
                        if (knows.contains(a)) {
                            isOk[i] = false;
                            for (int b : adj[i]) knows.add(b);
                            break;
                        }
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < M; i++) {
                if (isOk[i]) answer++;
            }
            System.out.println(answer);
        }
    }
}