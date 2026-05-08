import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        List<int[]> pick = new ArrayList<>();
        
        int idx = -1;
        if (ext.equals("code")) idx = 0;
        else if (ext.equals("date")) idx = 1;
        else if (ext.equals("maximum")) idx = 2;
        else idx = 3;
        
        for (int[] d : data) {
            if (d[idx] < val_ext) pick.add(d);
        }
        
        int[][] answer = new int[pick.size()][4];
        for (int i = 0; i < pick.size(); i++) {
            answer[i] = pick.get(i);
        }
        
        
        Arrays.sort(answer, (o1, o2) -> {
            int i;
            if (sort_by.equals("code")) i = 0;
            else if (sort_by.equals("date")) i = 1;
            else if (sort_by.equals("maximum")) i = 2;
            else i = 3;
            return o1[i] - o2[i];
        });
        
        return answer;
    }
}