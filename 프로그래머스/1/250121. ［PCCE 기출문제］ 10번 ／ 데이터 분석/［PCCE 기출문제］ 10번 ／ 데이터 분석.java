import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> extIdx = new HashMap<>();
        extIdx.put("code", 0); extIdx.put("date", 1);
        extIdx.put("maximum", 2); extIdx.put("remain", 3);
        
        List<int[]> processedData = new ArrayList<>();
        int idx = extIdx.get(ext);
        for (int[] d : data) {
            if (d[idx] < val_ext) processedData.add(d);
        }
        
        int[][] answer = new int[processedData.size()][4];
        for (int i = 0; i < processedData.size(); i++) {
            answer[i] = processedData.get(i);
        }
        
        int sortIdx = extIdx.get(sort_by);
        Arrays.sort(answer, (o1, o2) -> o1[sortIdx] - o2[sortIdx]);
        
        return answer;
    }
}