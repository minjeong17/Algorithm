import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            
            int[][] res = new int[N][2];
            Map<Integer, Integer> teamCnt = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int teamNum = Integer.parseInt(st.nextToken());
                res[i][0] = teamNum;
                teamCnt.put(teamNum, teamCnt.getOrDefault(teamNum, 0) + 1);
            }
            
            int sc = 1;
            Map<Integer, Integer> teamScore = new HashMap<>();
            Map<Integer, Integer> top4 = new HashMap<>();
            for (int i = 0; i < N; i++) {
                if (teamCnt.get(res[i][0]) == 6) {
                    res[i][1] = sc;
                    if (!top4.containsKey(res[i][0]) || top4.get(res[i][0]) < 4) {
                        teamScore.put(res[i][0], teamScore.getOrDefault(res[i][0], 0) + sc);
                        top4.put(res[i][0], top4.getOrDefault(res[i][0], 0) + 1);
                    }
                    sc++;
                }
            }
            
            int ansT = -1;
            int ansS = Integer.MAX_VALUE;
            for (int team : teamScore.keySet()) {
                if (teamScore.get(team) < ansS) {
                    ansT = team;
                    ansS = teamScore.get(team);
                } else if (teamScore.get(team) == ansS) {
                    int[] cntCurr = new int[2]; 
                    int[] cntPrev = new int[2];
                    for (int i = N-1; i >= 0; i--) {
                        if (res[i][0] == team) {
                            cntCurr[0]++;
                            if (cntCurr[0] == 2) {
                                cntCurr[1] = res[i][1];
                            }
                        } else if (res[i][0] == ansT) {
                            cntPrev[0]++;
                            if (cntPrev[0] == 2) {
                                cntPrev[1] = res[i][1];
                            }
                        }
                        
                        if (cntCurr[1] != 0 && cntPrev[1] != 0) break;
                    }
                    
                    if (cntCurr[1] < cntPrev[1]) {
                        ansT = team;
                        ansS = teamScore.get(team);
                    }
                }
            }
            
            ans.append(ansT).append("\n");
        }
        
        System.out.println(ans.toString());
    }
}