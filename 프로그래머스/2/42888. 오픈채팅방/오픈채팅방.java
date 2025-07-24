import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> nickname = new HashMap<>();
        List<String> msg = new ArrayList<>();
        for (String rec : record) {
            String[] rc = rec.split(" ");
            
            if (rc[0].equals("Enter")) {
                msg.add(rc[1] + " 들어왔습니다.");
                nickname.put(rc[1], rc[2]);
            } else if (rc[0].equals("Leave")) {
                msg.add(rc[1] + " 나갔습니다.");
            } else {
                nickname.put(rc[1], rc[2]);
            }
        }
        
        String[] answer = new String[msg.size()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < msg.size(); i++) {
            String[] m = msg.get(i).split(" ");
            
            sb.append(nickname.get(m[0])).append("님이 ").append(m[1]);
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        
        return answer;
    }
}