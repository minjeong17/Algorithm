import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        // String[] tmp = today.split(.);
        // System.out.println(Arrays.toString(tmp));
        // System.out.println(today.substring(0, 4) + " " + today.substring(5, 7) + " " + today.substring(8));
        int todayParsed = Integer.parseInt(today.substring(0, 4)) * 28 * 12
                          + Integer.parseInt(today.substring(5, 7)) * 28 
                          + Integer.parseInt(today.substring(8));
        
        Map<String, Integer> termMap = new HashMap<>();
        for (String t : terms) {
            String[] tmp = t.split(" ");
            termMap.put(tmp[0], Integer.parseInt(tmp[1]) * 28);
        }
        
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");
            int date = Integer.parseInt(tmp[0].substring(0, 4)) * 28 * 12
                       + Integer.parseInt(tmp[0].substring(5, 7)) * 28 
                       + Integer.parseInt(tmp[0].substring(8));
            
            if (date + termMap.get(tmp[1]) - 1 < todayParsed) ansList.add(i+1);
        }
        
        int[] answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        
        
        return answer;
    }
}