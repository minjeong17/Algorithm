import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        String[] tmp = today.split("\\.");
        int[] date = new int[3];
        for (int i = 0; i < 3; i++) {
            date[i] = Integer.parseInt(tmp[i]);
        }
        
        Map<String, Integer> term = new HashMap<>();
        for (String str : terms) {
            tmp = str.split(" ");
            term.put(tmp[0], Integer.parseInt(tmp[1]));
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String str = privacies[i];
            
            String tmpp = str.substring(0, 10);
            tmp = tmpp.split("\\.");
            int[] getDate = new int[3];
            for (int ii = 0; ii < 3; ii++) {
                getDate[ii] = Integer.parseInt(tmp[ii]);
            }

            String type = str.charAt(str.length()-1)+"";
            getDate[1] += term.get(type);
            if (getDate[1] > 12) {
                int t = getDate[1] / 12;
                getDate[1] -= 12*t;
                getDate[0] += t;
                if (getDate[1] == 0) {
                    getDate[1] = 12;
                    getDate[0] -= 1;
                }
            } 
            
            if (getDate[2] == 1) {
                getDate[2] = 28;
                getDate[1] -= 1;
                if (getDate[1] == 0) {
                    getDate[1] = 12;
                    getDate[0] -= 1;
                }
            } else {
                getDate[2] -= 1;
            }
            
            for (int j = 0; j < 3; j++) {
                if (date[j] > getDate[j]) {
                    ans.add(i+1);
                    break;
                } else if (date[j] < getDate[j]) break;
            }
        }
        
        int[] answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}