import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                ans.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[] {start, end});

        int[][] answer = new int[ans.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i][0] = ans.get(i)[0];
            answer[i][1] = ans.get(i)[1];
        }

        return answer;
    }
}