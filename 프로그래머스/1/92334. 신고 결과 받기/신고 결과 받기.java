import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> idIdx = new HashMap<>(); // id의 인덱스
        for (int i = 0; i < id_list.length; i++) {
            idIdx.put(id_list[i], i);
        }
        
        Map<String, Integer> reportCnt = new HashMap<>(); // id가 신고 당한 횟수
        Map<String, Set<String>> whoReport = new HashMap<>(); // id를 누가 신고했는지
        for (String r : report) {
            String[] parsing = r.split(" ");
            
            if (!whoReport.containsKey(parsing[1]) || !whoReport.get(parsing[1]).contains(parsing[0]))
                reportCnt.put(parsing[1], reportCnt.getOrDefault(parsing[1], 0) + 1);
            
            if (whoReport.containsKey(parsing[1])) {
                Set<String> tmp = whoReport.get(parsing[1]);
                tmp.add(parsing[0]);
                whoReport.put(parsing[1], tmp);
            } else {
                Set<String> tmp = new HashSet<>();
                tmp.add(parsing[0]);
                whoReport.put(parsing[1], tmp);
            }
        }
        
        for (String id : reportCnt.keySet()) {
            if (reportCnt.get(id) >= k) {
                Set<String> repId = whoReport.get(id);
                for (String r : repId) {
                    int idx = idIdx.get(r);
                    answer[idx]++;
                }
            }
        }
        
        return answer;
    }
}