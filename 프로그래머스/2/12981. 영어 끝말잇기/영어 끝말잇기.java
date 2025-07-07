import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> used = new HashSet<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        
        char lastCh = words[0].charAt(0);
        
        int idx = 0;
        for (String word : words) {
            int num = idx++ % n;
            if (word.charAt(0) != lastCh) {
                answer[0] = num + 1;
                answer[1] = cnt.getOrDefault(num, 0) + 1;
                break;
            } else {
                if (used.contains(word)) {
                    answer[0] = num + 1;
                    answer[1] = cnt.getOrDefault(num, 0) + 1;
                    break;
                } else {
                    cnt.put(num, cnt.getOrDefault(num, 0) + 1);
                    used.add(word);
                    lastCh = word.charAt(word.length()-1);
                }
            }
        }
        
        return answer;
    }
}