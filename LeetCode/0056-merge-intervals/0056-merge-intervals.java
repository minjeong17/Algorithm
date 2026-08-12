import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        int[] check = new int[10000 + 1];
        Arrays.fill(check, -1);

        int maxI = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            for (int i = start; i <= end; i++) {
                if (check[i] != -1) {
                    int idx = i-1;
                    while (idx >= 0 && check[idx] == check[i]) {
                        check[idx] = end;
                        idx--;
                    }

                    idx = i+1;
                    while (idx <= 10000 && check[idx] == check[i]) {
                        check[idx] = end;
                        idx++;
                    }
                }
                check[i] = end;
            }

            maxI = Math.max(maxI, end);
        }


        int start = -1;
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i <= maxI; i++) {
            if (check[i] != -1 && start == -1) {
                start = i;
            } else if (i > 0 && check[i] != check[i-1]) {
                ans.add(new int[] {start, i-1});

                if (check[i] != -1) start = i;
                else start = -1;
            }
        }
        if (start != -1) ans.add(new int[] {start, maxI});

        int[][] answer = new int[ans.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i][0] = ans.get(i)[0];
            answer[i][1] = ans.get(i)[1];
        }

        return answer;
    }
}