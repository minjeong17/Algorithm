import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        int fNum = friends.length;
        Map<String, Integer> friendIdx = new HashMap<>();
        for (int i = 0; i < fNum; i++) {
            friendIdx.put(friends[i], i);
        }
        
        int[][] giftReport = new int[fNum][fNum];
        int[][] giftScore = new int[fNum][2]; // 0 : 줌, 1 : 받음
        for (String str : gifts) {
            String[] s = str.split(" ");
            int f1 = friendIdx.get(s[0]);
            int f2 = friendIdx.get(s[1]);
            
            giftReport[f1][f2]++;
            
            giftScore[f1][0]++;
            giftScore[f2][1]++;
        }
        
        int[] cnt = new int[fNum];
        for (int i = 0; i < fNum; i++) {
            for (int j = i+1; j < fNum; j++) {
                if (giftReport[i][j] != 0 || giftReport[j][i] != 0) {
                    if (giftReport[i][j] > giftReport[j][i]) {
                        cnt[i]++;
                    } else if (giftReport[i][j] < giftReport[j][i]) {
                        cnt[j]++;
                    } else {
                        int sc1 = giftScore[i][0] - giftScore[i][1];
                        int sc2 = giftScore[j][0] - giftScore[j][1];
                        
                        if (sc1 > sc2) cnt[i]++;
                        else if (sc1 < sc2) cnt[j]++;
                    }
                } else if ((giftReport[i][j] == 0 && giftReport[j][i] == 0)
                          || (giftReport[i][j] == giftReport[j][i])) {
                        int sc1 = giftScore[i][0] - giftScore[i][1];
                        int sc2 = giftScore[j][0] - giftScore[j][1];
                        
                        if (sc1 > sc2) cnt[i]++;
                        else if (sc1 < sc2) cnt[j]++;
                }
                
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for (int n : cnt) answer = Math.max(answer, n);
        
        return answer;
    }
}