import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nickname = new HashMap<>();
        List<String[]> msg = new ArrayList<>();
        for (String r : record) {
            String[] tmp = r.split(" ");
            
            if (tmp[0].equals("Change")) {
                nickname.put(tmp[1], tmp[2]);
            } else if (tmp[0].equals("Enter")) {
                nickname.put(tmp[1], tmp[2]);
                msg.add(new String[] {tmp[0], tmp[1]});
            } else {
                msg.add(new String[] {tmp[0], tmp[1]});
            }
        }
                
        String[] answer = new String[msg.size()];
        for (int i = 0; i < answer.length; i++) {
            String[] m = msg.get(i);
            
            if (m[0].equals("Enter")) {
                answer[i] = nickname.get(m[1]) + "님이 들어왔습니다.";
            } else {
                answer[i] = nickname.get(m[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}