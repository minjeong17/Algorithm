import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, Integer> idIdx = new HashMap<>();
        Map<String, Integer> repCnt = new HashMap<>();
        Map<String, Set<String>> userReports = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            idIdx.put(id, i);
            repCnt.put(id, 0);
            userReports.put(id, new HashSet<>());
        }
        
        for (String rep : report) {
            String[] r  = rep.split(" ");
            if (!userReports.get(r[1]).contains(r[0])) {
                repCnt.put(r[1], repCnt.get(r[1]) + 1);
                userReports.get(r[1]).add(r[0]);
            }
        }
        
        int[] answer = new int[id_list.length];
        for (String id : repCnt.keySet()) {
            if (repCnt.get(id) >= k) {
                for (String i : userReports.get(id)) {
                    answer[idIdx.get(i)]++;
                }
            }
        }
        
        return answer;
    }
}