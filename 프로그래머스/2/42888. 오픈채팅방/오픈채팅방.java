import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> idToNick = new HashMap<>();
        Queue<String[]> messages = new LinkedList<>();
        
        for (String r : record) {
            String[] parsed = r.split(" ");
            
            if ("Enter".equals(parsed[0])) {
                idToNick.put(parsed[1], parsed[2]);
                messages.add(new String[] {parsed[0], parsed[1]});
            } else if ("Leave".equals(parsed[0])) {
                messages.add(new String[] {parsed[0], parsed[1]});
            } else {
                idToNick.put(parsed[1], parsed[2]);
            }
        }
        
        int idx = 0;
        String[] answer = new String[messages.size()];
        while (!messages.isEmpty()) {
            String[] tmp = messages.poll();
            
            if ("Enter".equals(tmp[0])) {
                answer[idx++] = idToNick.get(tmp[1]) + "님이 들어왔습니다.";
            } else {
                answer[idx++] = idToNick.get(tmp[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}