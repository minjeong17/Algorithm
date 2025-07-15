import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        Map<String, Integer> idxNum = new HashMap<>();
        for (int i = 65; i < 91; i++) {
            idxNum.put(((char)i)+"", i - 64);
        }
        
        List<Integer> ans = new ArrayList<>();
        int idx = 27;
        StringBuilder sb = new StringBuilder();
        String prev = "";
        for (int i = 0; i < msg.length(); i++) {
            for (int j = i; j < msg.length(); j++) {
                sb.append(msg.charAt(j));
                if (idxNum.containsKey(sb.toString())) {
                    prev = sb.toString();
                    if (j == msg.length() - 1) {
                        ans.add(idxNum.get(prev));
                        i = msg.length();
                        break;
                    }
                } else {
                    ans.add(idxNum.get(prev));
                    idxNum.put(sb.toString(), idx++);
                    sb.setLength(0);
                    prev = "";
                    i = j - 1;
                    break;
                }
            }
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer; 
    }
}