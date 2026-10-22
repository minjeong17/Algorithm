import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        System.out.println(Arrays.deepToString(intervals));

        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] prev = ans.get(ans.size() - 1);

            if (prev[1] >= interval[0]) {
                if (prev[1] < interval[1]) ans.get(ans.size() - 1)[1] = interval[1];
            } else ans.add(interval);
        }

        return ans.toArray(new int[0][]);
    }
}