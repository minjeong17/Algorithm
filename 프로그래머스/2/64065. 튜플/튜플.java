import java.util.*;

class Solution {
    public int[] solution(String s) {

        Map<Integer, Integer> numCnt = new HashMap<>();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch-'0' >= 0 && ch-'0' <= 9) {
                num.append(ch);
            } else {
                if (num.length() != 0) {
                    int tmp = Integer.parseInt(num.toString());
                    numCnt.put(tmp, numCnt.getOrDefault(tmp, 0) + 1);
                    num.setLength(0);
                }
            }
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(numCnt.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        
        int[] answer = new int[numCnt.size()];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            answer[idx++] = entry.getKey();
        }        
        
        return answer;
    }
}