import java.util.*;

class Solution {

    public String solution(String[] survey, int[] choices) {
        
        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        
        Map<Character, Integer> score = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            score.put(types[i][0], 0);
            score.put(types[i][1], 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] > 4) {
                char type = survey[i].charAt(1);
                score.put(type, score.get(type) + choices[i]-4);
            } else if (choices[i] < 4) {
                char type = survey[i].charAt(0);
                score.put(type, score.get(type) + (4 - choices[i]));
            }
        }       
        
        StringBuilder ans = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            char type1 = types[i][0];
            char type2 = types[i][1];
            
            if (score.get(type1) > score.get(type2)) {
                ans.append(type1);
            } else if (score.get(type2) > score.get(type1)) {
                ans.append(type2);
            } else {
                ans.append(type1 > type2 ? type2 : type1);
            }
        }

        return ans.toString();
    }
    
}