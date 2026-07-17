import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        char last = words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            if (last != word.charAt(0) || set.contains(word)) {
                answer[0] = (i + 1) % n == 0 ? n : (i + 1) % n;
                answer[1] = (int)Math.ceil((i + 1.0) / n);
                break;
            }
            
            last = word.charAt(word.length()-1);
            set.add(word);
        }
        
        
        return answer;
    }
}