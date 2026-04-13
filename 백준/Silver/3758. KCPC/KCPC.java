import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int tt = 0; tt < T; tt++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int[][] solve = new int[n+1][k+1];
            int[][] cntNtime = new int[n+1][2]; // 0 : 횟수, 1 : 마지막 제출 시간
            for (int mm = 0; mm < m; mm++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                
                if (solve[i][j] == 0 || solve[i][j] < s) {
                    solve[i][j] = s;
                }
                
                cntNtime[i][0]++;
                cntNtime[i][1] = mm;
            }
            
            int[][] tmp = new int[n][2]; // 0 : 팀 번호, 2 : 점수
            for (int i = 1; i <= n; i++) {
                tmp[i-1][0] = i;
                int sc = 0;
                for (int j = 1; j <= k; j++) {
                    sc += solve[i][j];
                }
                tmp[i-1][1] = sc;
            }
            
            Arrays.sort(tmp, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    if (cntNtime[o1[0]][0] == cntNtime[o2[0]][0]) {
                        return cntNtime[o1[0]][1] - cntNtime[o2[0]][1];
                    }
                    return cntNtime[o1[0]][0] - cntNtime[o2[0]][0];
                }
                return o2[1] - o1[1];
            });
            
            for (int i = 0; i < n; i++) {
                if (tmp[i][0] == t) {
                    ans.append(i+1).append("\n");
                    break;
                }
            }
        }
        
        System.out.println(ans.toString());
    }
}